create database kbproject;
USE kbproject;

CREATE TABLE `user`
(
    `user_number`   bigint(20)  NOT NULL auto_increment primary key,
    `user_id`       varchar(20) NOT NULL unique,
    `user_password` varchar(20) NOT NULL,
    `name`          varchar(20) NOT NULL
);

CREATE TABLE `product`
(
    `product_id`   bigint(20)   NOT NULL auto_increment primary key,
    `product_type` char(1)      NOT NULL,
    `product_name` varchar(255) NOT NULL,
    `image_path`   varchar(255) NULL,
    `product_url`  varchar(255) NULL,
    `benefit`      varchar(255) NULL,
    `product_code` varchar(255) NULL
);

CREATE TABLE `custom_page`
(
    `page_id`     bigint(20)   NOT NULL auto_increment primary KEY,
    `user_number` bigint(20)   NOT NULL unique,
    `layout_data` longtext     NULL,
    `image_url`   varchar(255) NULL,
    FOREIGN KEY (user_number) REFERENCES user (user_number)
);

#   layout_data_column
#   `위젯ID`
# 	`x좌표`
# 	`y좌표`
# 	`세로길이`
# 	`가로길이`

#   `여기부터는 선택`
# 	`다중페이지번호`
# 	`위젯이미지`
# 	`위젯설정`?

CREATE TABLE `custom_community`
(
    `shared_id`   bigint(20)   NOT NULL auto_increment primary KEY,
    `user_number` bigint(20)   NOT NULL,
    `page_name`   varchar(255) NOT NULL,
    `layout_data` longtext     NULL,
    `image_url`   varchar(255) NULL,
    `heart`       bigint(20)   NULL,
    FOREIGN KEY (user_number) REFERENCES user (user_number)
);

CREATE TABLE `account`
(
    `account_number` bigint(20)   NOT NULL primary KEY,
    `user_number`    bigint(20)   NOT NULL,
    `account_type`   varchar(255) NULL,
    `balance`        bigint(20)   NULL,
    FOREIGN KEY (user_number) REFERENCES user (user_number)
);

INSERT INTO `product`
VALUES (86, '1', 'WE:SH All 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09122_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09122',
        '국내 이용, \n해외 이용, \n쇼핑 멤버십/OTT/이동통신, \n', '09122'),
       (87, '1', 'WE:SH Daily 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09570_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09570',
        '국내 가맹점, \n편의점/커피/올리브영 등, \n데일리 스탬프 연계 전월실적 채워드림, \n', '09570'),
       (88, '1', '가온올림카드(실속형)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09157_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09157',
        '국내가맹점, \n주말/공휴일, \n음식·교통, \n', '09157'),
       (89, '1', 'The Easy카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09250_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09250',
        '기본 적립/할인, \n추가 적립, \n추가 할인, \n', '09250'),
       (90, '1', '마이핏카드(적립형)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09247_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09247', '간편결제, \n편의점/택시, \n쇼핑/배달, \n',
        '09247'),
       (91, '1', 'KB Pay 챌린지카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09113_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09113',
        'KB Pay 3회당, \nKB Pay 매일 결제 시, \n', '09113'),
       (92, '1', 'KB Pay 챌린지+카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09114_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09114',
        'KB Pay 3회당, \nKB Pay 매일 결제 시, \n이용 리워드, \n', '09114'),
       (93, '1', 'toss KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04350_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04350', '전월실적 한도없이, \n스타벅스 이용 시, \n',
        '04350'),
       (94, '1', 'My WE:SH 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09123_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09123',
        'KB Pay/음식/OTT, \n배달/커피/영화/미용실 등, \nHappy Birth Month / 전월실적 채워드림, \n', '09123'),
       (95, '1', '청춘대로 톡톡카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09174_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09174',
        '스타벅스, \n버거/패스트푸드, \n간편결제 Pay, \n', '09174'),
       (96, '1', '다담카드(비 OTP)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09169_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09169',
        '교통/통신/해외, \n생활/교육/쇼핑, \n연간리워드, \n', '09169'),
       (97, '1', 'CU KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09060_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09060',
        'CU 최대, \n이동 통신 요금 자동납부, \nOTT 정기결제, \n', '09060'),
       (98, '1', '톡톡 with카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09272_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09272', '스타벅스, \n온라인 간편결제, \n구독, \n',
        '09272'),
       (99, '1', 'Easy on카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09244_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09244', '푸드, \n특화서비스, \nPlus 서비스, \n',
        '09244'),
       (100, '1', '요기패스 신용카드(가로형)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04284_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04284',
        '요기패스 멤버십, \n생활업종, \n구독서비스, \n', '04284'),
       (101, '1', '랭킹닭컴 신용카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04289_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04289',
        '랭킹닭컴, \n골프(연습)장, \n구독서비스, \n', '04289'),
       (102, '1', '마이핏카드(할인형)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09248_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09248', '외식/커피, \n편의/생활, \n쇼핑/배달, \n',
        '09248'),
       (103, '1', 'K-패스카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09321_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09321',
        '대중교통, \n생활서비스, \nKB Pay 이용 시 생활서비스, \n', '09321'),
       (104, '1', 'EV 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/00230_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=00230',
        '전기/수소차 충전, \n주차, 세차, \nOTT, \n', '00230'),
       (105, '1', 'American Express Blue Card',
        'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09115_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09115',
        '온라인 쇼핑(KB Pay), \n주유, \n이동통신요금, \n', '09115'),
       (106, '1', '굿데이올림카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09063_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09063', '주유, \n통신/교통, \n대형마트, \n',
        '09063'),
       (107, '1', 'Easy pick카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09243_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09243',
        '주요 생활 영역, \n선호 영역(택1), \n일상 생활 영역, \n', '09243'),
       (108, '1', 'Easy auto 티타늄카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09246_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09246',
        '주유(SK,GS), \n정비,주차,세차, \n자동차보험, \n', '09246'),
       (109, '1', 'TMAP KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09389_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09389', '티맵, \nOTT, \n주유, 식음료, \n',
        '09389'),
       (110, '1', 'SK에너지 러브유 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02245_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02245', 'SK에너지, \n스피드메이트, \n대중교통, \n',
        '02245'),
       (111, '1', 'GS행복가득카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04863_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04863', 'GS칼텍스, \n오토오아시스, \n대중교통, \n',
        '04863'),
       (112, '1', 'E1 LPG KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04459_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04459',
        'E1 LPG 충전소, \n골프, 쇼핑, 외식, \n', '04459'),
       (113, '1', '쿠팡 와우 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09292_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09292',
        '쿠팡, 쿠팡이츠, 쿠팡플레이, \n국내·외 가맹점, \n', '09292'),
       (114, '1', '이마트II KB국민카드(옐로우)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04361_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04361',
        '이마트/트레이더스, \n스타벅스&생활업종, \n구독서비스, \n', '04361'),
       (115, '1', 'American Express Rose Gold Card',
        'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09116_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09116',
        '온라인 쇼핑, \n커피, 편의점, \n오프라인 쇼핑, 온라인 항공/면세점, \n', '09116'),
       (116, '1', '갤러리아 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04491_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04491', '갤러리아 백화점, \n갤러리아 백화점, \n',
        '04491'),
       (117, '1', 'LFmall 신용카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09314_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09314', 'LFmall, \n국내외 가맹점, \n',
        '09314'),
       (118, '1', 'The CJ KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/01142_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=01142', 'CJ푸드빌, \nCJ온스타일, \nCGV, \n',
        '01142'),
       (119, '1', 'Easy shopping카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09064_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09064',
        'Shopping 서비스, \n선택서비스 (택1), \n+KB Pay 서비스, \n', '09064'),
       (120, '1', '톡톡 Pay카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09231_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09231',
        '간편결제(Pay), \n대중교통, \n편의점, \n', '09231'),
       (121, '1', '위메프페이 신용카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04327_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04327',
        '위메프, \n위메프오, \n생활영역/구독서비스, \n', '04327'),
       (122, '1', '롯데마트 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09180_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09180', '롯데마트, \n택시/커피, \n놀이공원, \n',
        '09180'),
       (123, '1', 'CHALLENGE BAG KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04409_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04409',
        '11번가 OK캐쉬백, \n생활밀착업종 OK캐쉬백, \n전가맹점 OK캐쉬백, \n', '04409'),
       (124, '1', 'GS SHOP KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04431_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04431',
        'GS SHOP, \n마트/통신, \n커피/편의점/택시, \n', '04431'),
       (125, '1', 'AK KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04444_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04444', 'AK 특화서비스, \n생활영역 할인, \n',
        '04444'),
       (126, '1', 'H.Point KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04415_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04415', 'H.Point, \n생활영역, \n',
        '04415'),
       (127, '1', '삼성페이 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04434_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04434', '삼성 페이 간편결제, \n주요 생활영역, \n',
        '04434'),
       (128, '1', 'WE:SH Travel', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09561_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09561',
        '해외 이용 수수료, \n해외 이용 금액, \n쇼핑/커피/편의점/영화관, \n', '09561'),
       (129, '1', '스카이패스 티타늄 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04285_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04285',
        '국내가맹점 적립, \n해외이용 적립, \n적립한도 : 월별, \n', '04285'),
       (130, '1', '아시아나 올림카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09194_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09194',
        '국내 이용금액 적립, \n해외 이용금액 적립, \n', '09194'),
       (131, '1', '제주항공 Refresh Point KB국민카드',
        'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04420_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04420', 'RefreshPoint, \n공항라운지, \n',
        '04420'),
       (132, '1', '모두투어 투어마일리지 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04422_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04422', '투어마일리지, \n외식/커피, \n놀이공원, \n',
        '04422'),
       (133, '1', 'Our WE:SH 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09124_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09124',
        '\'우리\'를 위한, \n‘두리(소중한 당신)’을 위한, \n통신료, \n', '09124'),
       (134, '1', '골든라이프올림카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04451_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04451',
        '병원or마트, \n6대 영역, \n3대 영역, \n', '04451'),
       (135, '1', 'KB손해보험 마이펫카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09383_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09383',
        '펫 보험료, \n동물병원&애완동물 업종, \n배달&간식, \n', '09383'),
       (136, '1', '밀크T 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/220608_04320_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04320', '밀크T 학습비 자동이체, \n', '04320'),
       (137, '1', '웅진씽크빅 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02171_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02171', '웅진씽크빅 자동납부, \n', '02171'),
       (138, '1', '윙크Ⅱ카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04334_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04334', '학습비 자동납부, \n', '04334'),
       (139, '1', '비상온리원 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02210_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02210', '비상온리원 자동납부, \n', '02210'),
       (140, '1', '반려愛카드(강아지)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04260_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04260', '반려동물, \n대형마트, \n온라인쇼핑몰, \n',
        '04260'),
       (141, '1', 'KB국민 펫코노미 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04404_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04404',
        '반려동물 업종, \n대형마트, \n반려견 단체보험, \n', '04404'),
       (142, '1', 'T-economy KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04288_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04288', 'SKT 통신요금 자동납부, \n', '04288'),
       (143, '1', 'LG 헬로비전 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02170_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02170', 'LG 헬로비전 자동납부, \n', '02170'),
       (144, '1', 'Liiv M Ⅱ 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04241_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04241', 'Liiv M 통신요금 자동이체, \n',
        '04241'),
       (145, '1', '코웨이Ⅱ 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04423_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04423',
        '코웨이 렌탈료, \n코웨이 연간리워드, \n놀이공원, \n', '04423'),
       (146, '1', 'SK매직 올림카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04418_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04418', 'SK매직 렌탈료, \n놀이공원, \n',
        '04418'),
       (147, '1', '교원 웰스 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04417_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04417',
        '교원웰스 렌탈료, \n패밀리레스토랑, \n놀이공원, \n', '04417'),
       (148, '1', '청호나이스Ⅱ카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04336_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04336', '렌탈료 자동납부, \n', '04336'),
       (149, '1', '토스모바일 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04351_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04351', '토스모바일 통신요금 자동납부, \n',
        '04351'),
       (150, '1', 'Wavve 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04287_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04287',
        'Wavve 월 이용권, \n식음료, \n멤버십 구독, \n', '04287'),
       (151, '1', 'LG전자 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04425_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04425', '라이트할부, \n렌탈요금, \n', '04425'),
       (152, '1', '쿠쿠렌탈Ⅱ카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04325_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04325', '렌탈료 자동납부, \n', '04325'),
       (153, '1', '세라젬 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04331_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04331', '렌탈료 자동납부, \n', '04331'),
       (154, '1', '예다함 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04485_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04485', '예다함 상조부금, \n', '04485'),
       (155, '1', '딜라이브 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04345_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04345', '딜라이브 자동납부요금, \n', '04345'),
       (156, '1', '알뜰폰 Hub Ⅱ 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04324_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04324', '알뜰폰 통신요금 자동이체, \n', '04324'),
       (157, '1', 'KMVNO 알뜰폰 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04290_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04290', 'KMVNO 알뜰폰 통신요금 자동이체, \n',
        '04290'),
       (158, '1', '사장님카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09291_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09291',
        '보안·용역/사무기기/정수기렌탈, \n온라인광고/쇼핑, \n음식점/커피/편의점/다이소/슈퍼마켓/주유/골프, \n', '09291'),
       (159, '1', '캐시노트 KB국민카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04291_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04291',
        '캐시노트 멤버십, \n국내외 가맹점, \n사업지원영역, \n', '04291'),
       (160, '1', '탄탄대로 Biz카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09183_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09183',
        '주유소(SK/GS), \n마트, 식자재매장, \n인터넷쇼핑몰, \n', '09183'),
       (161, '1', '가온 Biz카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09176_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09176',
        '국내 가맹점, \n주유/통신/전자상거래, \n건당 고액결제, \n', '09176'),
       (162, '1', '국민행복카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02065_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02065',
        '쇼핑/교육/자동납부, \n단체보험가입, \n단체보험가입, \n', '02065'),
       (163, '1', 'KB국민 군인연금증 신용카드(비사진)', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04131_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04131', '5대 업종, \n군 복지시설, \n주유, \n',
        '04131'),
       (164, '1', '국방멤버쉽카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/00996_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=00996',
        '군휴양시설/체력단련장, \nGS칼텍스, \n모든가맹점, \n', '00996'),
       (165, '1', '스타트럭Ⅱ GS칼텍스카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04095_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04095', '영업용화물차, \nGS칼텍스 경유, \n',
        '04095'),
       (166, '1', '스타트럭플러스 S-OIL카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04088_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04088', '영업용화물차, \nS-OIL주유소(경유), \n',
        '04088'),
       (167, '1', '스타트럭 플러스 HD현대오일뱅크카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04092_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04092', '영업용화물차, \nHD현대오일뱅크 경유, \n',
        '04092'),
       (168, '1', 'STARTLUCK 카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02076_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02076', '영업용화물차, \nGS칼텍스(경유), \n',
        '02076'),
       (169, '1', 'SK내트럭 유가보조금카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04550_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04550', '영업용화물차, \nSK에너지(경유), \n',
        '04550'),
       (170, '1', '보탬e전용카드', 'https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09084_img.png',
        'https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09084',
        '카드사용알림서비스(SMS), \n연회비, \n클린카드 기능, \n', '09084');

-- 1. 사회초년생
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB국민첫재테크적금', '사회초년생, 기간: 36개월, 이율: 연 2.75% ~ 3.25%', NULL, NULL, NULL),
       ('2', 'KB국민행복적금', '사회초년생, 기간: 12개월, 이율: 연 3.5% ~ 5.5%', NULL, NULL, NULL);

-- 2. 직장인
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', '직장인우대적금', '직장인, 기간: 36개월, 이율: 연 3.55% ~ 4.05%', NULL, NULL, NULL),
       ('2', 'KB국민프리미엄적금 (자유적립식)', '직장인, 기간: 60개월, 이율: 연 2.9% ~ 4.2%', NULL, NULL, NULL);

-- 3. 어린이, 청소년
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB Young Youth 적금', '어린이, 청소년, 기간: 12개월, 이율: 연 2.1% ~ 3.4%', NULL, NULL, NULL),
       ('2', 'KB아이사랑적금 NEW', '어린이, 청소년, 기간: 12개월, 이율: 연 2% ~ 10%', NULL, NULL, NULL);

-- 4. 특별, 맞춤형
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB내맘대로적금', '특별, 맞춤형, 기간: 36개월, 이율: 연 3.15% ~ 3.75%', NULL, NULL, NULL),
       ('2', 'KB특★한 적금', '특별, 맞춤형, 기간: 1개월, 이율: 연 2% ~ 6%', NULL, NULL, NULL),
       ('2', 'KB국민프리미엄적금 (정액적립식)', '특별, 맞춤형, 기간: 60개월, 이율: 연 3% ~ 4.3%', NULL, NULL, NULL);

-- 5. 목돈
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB상호부금(자유적립식)', '목돈, 기간: 36개월, 이율: 연 2.9% ~ 3.3%', NULL, NULL, NULL),
       ('2', 'KB상호부금(정액적립식)', '목돈, 기간: 36개월, 이율: 연 3% ~ 3.4%', NULL, NULL, NULL);

-- 6. 재테크
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB스타적금Ⅱ NEW', '재테크, 기간: 12개월, 이율: 연 2% ~ 8%', NULL, NULL, NULL),
       ('2', 'KB차차차 적금', '재테크, 기간: 12개월, 이율: 연 2.5% ~ 8%', NULL, NULL, NULL);

-- 7. 미래
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB장병내일준비적금', '미래, 기간: 24개월, 이율: 연 5% ~ 8%', NULL, NULL, NULL),
       ('2', 'KB청년도약계좌', '미래, 기간: 60개월, 이율: 연 4.5% ~ 6%', NULL, NULL, NULL);

-- 8. 건강
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', '온국민 건강적금', '건강, 기간: 6개월, 이율: 연 2% ~ 8%', NULL, NULL, NULL),
       ('2', '온국민 건강적금-골든라이프', '건강, 기간: 6개월, 이율: 연 2% ~ 10%', NULL, NULL, NULL);

-- 9. 반려동물
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB반려행복적금', '반려동물, 기간: 36개월, 이율: 연 3.25% ~ 4.75%', NULL, NULL, NULL);

-- 10. 여행
INSERT INTO `product` (`product_type`, `product_name`, `benefit`, `image_path`, `product_url`, `product_code`)
VALUES ('2', 'KB두근두근여행적금', '여행 노랑풍선 할인쿠폰, 기간: 6개월, 이율: 연 2.65% ~ 3.65%', NULL, NULL, NULL);


Insert INTO account
VALUES (33333322111111, 1, '입출금', 1000000),
       (22222211333333, 2, '입출금', 0);

INSERT INTO `custom_community` VALUES (1,1,'민철이랑 놀아요','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C1.png',1),(2,1,'용우랑','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C2.png',1),(3,2,'소진이랑','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C3.png',1),(4,1,'수대랑','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C4.png',1),(5,2,'종수랑','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C5.png',1),(6,1,'학민이랑','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C6.png',1);