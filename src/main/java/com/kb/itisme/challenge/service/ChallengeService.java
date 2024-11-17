    package com.kb.itisme.challenge.service;

    import com.kb.itisme.challenge.domain.Challenge;
    import com.kb.itisme.challenge.domain.Payment;
    import com.kb.itisme.challenge.repo.ChallengeRepository;
    import com.kb.itisme.challenge.repo.PaymentRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.time.LocalDate;
    import java.time.ZoneId;
    import java.util.List;
    import java.util.Optional;

    @Service
    @RequiredArgsConstructor
    @Transactional
    public class ChallengeService {
        private final ChallengeRepository challengeRepository;
        private final PaymentRepository paymentRepository;
        public Long saveChallenge(Challenge challenge){
            challengeRepository.save(challenge);

            return challenge.getCno();
        }

        public List<Challenge> findAllChallenges() {
        return challengeRepository.findAll();
        }

        public Optional<Challenge> findChallengeById(Long id){
            return challengeRepository.findById(id);
        }
        public boolean checkSpending(Long challengeId, Long userNum) {
            // 챌린지 정보 가져오기
            Challenge challenge = challengeRepository.findById(challengeId)
                    .orElseThrow(() -> new IllegalArgumentException("Challenge not found"));

            // 챌린지 날짜 범위 설정
            LocalDate startDate = challenge.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = startDate.plusDays(30); // 30일 동안의 지출 검증

            // 해당 사용자와 날짜 범위에 맞는 지출 내역 가져오기
            List<Payment> payments = paymentRepository.findPaymentsByUser_UserNumAndDateBetween(userNum, startDate, endDate);

            // 지출 금액 합계 계산
            double totalSpent = payments.stream()
                    .mapToDouble(Payment::getAmount)
                    .sum();

            // 만원 이상인지 체크
            if (totalSpent <= 10000) {
                System.out.println("성공"); // 만원 초과
                return true; // 성공
            } else {
                System.out.println("실패"); // 만원 이하
                return false; // 실패
            }
        }


        public String calculateTotalMonthlyExpenseWithComparison(Long userNum, Long challengeId) {
            // 챌린지 정보 가져오기
            Challenge challenge = challengeRepository.findById(challengeId)
                    .orElseThrow(() -> new IllegalArgumentException("Challenge not found"));

            Long startPrice = challenge.getStartPrice(); // StartPrice 가져오기

            LocalDate now = LocalDate.now();
            LocalDate startDate = now.withDayOfMonth(1); // 이번 달의 첫 날
            LocalDate endDate = now.withDayOfMonth(now.lengthOfMonth()); // 이번 달의 마지막 날

            List<Payment> payments = paymentRepository.findPaymentsByUser_UserNumAndDateBetween(userNum, startDate, endDate);

            // 지출 합계 계산
            double totalExpense = payments.stream()
                    .mapToDouble(Payment::getAmount) // Payment 객체에서 금액을 가져옴
                    .sum(); // 모든 금액을 합산

            // StartPrice와 지출 총액 비교
            String comparisonResult;
            if (totalExpense < startPrice) {
                comparisonResult = "지출이 StartPrice보다 낮습니다.";
                challenge.setMonthlyStatus(true); // 월별 지출 상태를 true로 설정
            } else {
                comparisonResult = "지출이 StartPrice보다 높습니다.";
                challenge.setMonthlyStatus(false); // 월별 지출 상태를 false로 설정
            }

            // 챌린지 업데이트
            challengeRepository.save(challenge);

            return comparisonResult;
        }
    }
