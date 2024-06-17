import HomeHeader from "../../components/home/HomeHeader";
import BookInfoDetail from "../../components/book/BookInfoDetail";
import BookInfo from "../../components/book/BookInfo";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";

function BookDetail(){
    const {bookId} = useParams();
    const [book, setBook] = useState([]);

    useEffect(() => {
        fetch(`${process.env.REACT_APP_API_URL}/api/book/${bookId}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("책 상세 정보 조회 에러");
                }
                return response.json();
            })
            .then((json) => {
                setBook({
                    book_id: json.id,
                    book_name: json.bookName,
                    book_price: json.bookPrice,
                    book_stock: json.stock,
                    book_author: json.author,
                    book_publisher: json.publisher,
                    book_detail: json.bookDetail,
                    book_content: json.tableOfContents,
                    book_category: json.category.categoryName,
                    img_url: json.bookImgUrl
                });
            })
            .catch((error) => (
                console.log("책 상세 정보 조회 에러", error)
            ))
    }, [bookId]);

    return (
        <div>
            {/*{book.map((book) => (*/}
            <div key={book.book_id}>
                <HomeHeader/>
                <BookInfo book={book} />
                <BookInfoDetail book={book} />
            </div>
            {/*))}*/}
        </div>
    );
}

export default BookDetail;