import HomeHeader from "../../components/home/HomeHeader";
import BookInfoDetail from "../../components/book/BookInfoDetail";
import BookInfo from "../../components/book/BookInfo";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import bookData from "../bookTest/testBookData.json";

function BookDetail(){
    const {bookId} = useParams();
    const [books, setBooks] = useState([]);

    // 테스트코드
    useEffect(() => {
        const thisBook = bookData.find((book) => book.id === parseInt(bookId));
        if (thisBook) {
            setBooks([
                {
                    book_id: thisBook.id,
                    book_name: thisBook.bookName,
                    book_price: thisBook.bookPrice,
                    book_stock: thisBook.stock,
                    book_detail: thisBook.bookDetail,
                    category_id: thisBook.categoryId,
                    category_name: thisBook.categoryName,
                    img_url: thisBook.bookImgUrl,
                    book_content: thisBook.tableOfContents,
                }
            ]);
        } else {
            throw new Error("해당 책 정보를 찾을 수 없습니다.");
        }
    }, [bookId]);

    {/*
    !부모카테고리추가!
    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_URL}/api/book/${bookId}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("책 상세 정보 조회 에러");
                }
                return response.json();
            })
            .then((json) => {
                const thisBook = json.find((book) => book.id === parseInt(bookId));
                if (thisBook) {
                    setBooks({
                        book_id: thisBook.id,
                        book_name: thisBook.bookName,
                        book_price: thisBook.bookPrice,
                        book_stock: thisBook.stock,
                        book_detail: thisBook.bookDetail,
                        category_id: thisBook.category.id,
                        category_name: thisBook.category.categoryName,
                        img_url: thisBook.bookImgDtoList[0].imgUrl,
                        book_content: thisBook.tableOfContents,
                    });
                } else {
                    throw new Error("해당 책 정보를 찾을 수 없습니다.");
                }
            })
            .catch((error) => (
                console.log("책 상세 정보 조회 에러", error)
            ))
    }, [bookId]);
    */}

    return (
        <div>
            {books.map((book) => (
                <div key={book.book_id}>
                    <HomeHeader/>
                    <BookInfo book={book} />
                    <BookInfoDetail book={book} />
                </div>
            ))}
        </div>
    );
}

export default BookDetail;