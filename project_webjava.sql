create database project_db;
use project_db;

CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO admin (username, password)
VALUES ('admin', 'admin123');

CREATE TABLE book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    category VARCHAR(100),
    quantity INT DEFAULT 0,
    publish_year INT,
    image VARCHAR(255) NOT NULL
);

INSERT INTO book (title, author, category, quantity, publish_year, image) VALUES
                ('Lập trình Java cơ bản', 'Nguyễn Văn A', 'Công nghệ', 15, 2020, 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1629202926i/43230197.jpg'),
                ('Học Python qua ví dụ', 'Trần Thị B', 'Công nghệ', 10, 2019, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSy8TM5RrhDFmM4wPC1Y2lhZmKMFP9_wKT6fw&s'),
                ('Thiết kế Web với HTML/CSS', 'Phạm Văn C', 'Thiết kế', 12, 2021, 'https://vnskills.edu.vn/wp-content/uploads/2022/09/sach-hoc-lap-trinh-web-1.jpg'),
                ('Cơ sở dữ liệu MySQL', 'Lê Thị D', 'Cơ sở dữ liệu', 8, 2018, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9Z24QO6LbHik_Hrt5_XwgQz1hh_1CORSHOw&s'),
                ('Thuật toán và cấu trúc dữ liệu', 'Đinh Văn E', 'Kỹ thuật', 20, 2022, 'https://images.nxbxaydung.com.vn/Picture/2021/6/28/image-20210628144938783.jpg'),
                ('Java nâng cao', 'Nguyễn Văn F', 'Công nghệ', 5, 2023, 'https://xemsachhay.com/wp-content/uploads/2018/04/12352_p18732.jpg'),
                ('Python Machine Learning', 'Lê Thị G', 'Trí tuệ nhân tạo', 7, 2022, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSysKOKujtpYPcaahbjbQNVdAiKE8DvPRsohg&s'),
                ('Tư duy phản biện', 'Ngô Văn H', 'Kỹ năng sống', 9, 2021, 'https://cdn1.fahasa.com/media/catalog/product/i/m/image_195509_1_18448.jpg'),
                ('Kỹ năng giao tiếp', 'Phạm Thị I', 'Kỹ năng sống', 14, 2020, 'https://nhasachphuongnam.com/images/detailed/126/ky-nang-giao-tiep-dinh-cao.jpg'),
                ('Lịch sử Việt Nam', 'Trần Văn J', 'Lịch sử', 11, 2017, 'https://thuvientinh.quangngai.gov.vn/wp-content/uploads/2021/07/Lich-su-Viet-Nam-tap-1.jpg');

CREATE TABLE reader (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    birthdate DATE NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE borrow (
    id INT PRIMARY KEY AUTO_INCREMENT,
    reader_id INT,
    borrow_date DATE NOT NULL,
    return_date DATE,
    status ENUM('BORROWED', 'RETURNED') NOT NULL,
    FOREIGN KEY (reader_id) REFERENCES reader(id)
);

CREATE TABLE borrow_details (
    borrow_id INT,
    book_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY (borrow_id, book_id),
    FOREIGN KEY (borrow_id) REFERENCES borrow(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);
