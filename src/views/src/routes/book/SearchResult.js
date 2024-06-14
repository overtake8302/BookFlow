import React, { useState, useEffect } from 'react';
import ReactPaginate from 'react-paginate';


const SearchResult = () => {
  const [books, setBooks] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    fetchBooks(currentPage);
  }, [currentPage]);

  const fetchBooks = (page) => {
    fetch(`http://localhost:8080/books/search?keyword=yourKeyword&page=${page}&size=10&sort=id&direction=desc`)
      .then(response => response.json())
      .then(data => {
        setBooks(data.bookMainDtoList);
        setTotalPages(data.totalPages);
      })
      .catch(error => console.error('Error fetching data: ', error));
  };

  const handlePageClick = (event) => {
    const newPage = event.selected;
    setCurrentPage(newPage);
  };

  return (
    <div>
      <h1>Book List</h1>
      <ul>
        {books.map(book => (
          <li key={book.id}>
            <h2>{book.bookName}</h2>
            <p>{book.bookDetail}</p>
            {/* 이미지와 기타 정보를 여기에 표시 */}
          </li>
        ))}
      </ul>
      <ReactPaginate
        previousLabel={'previous'}
        nextLabel={'next'}
        breakLabel={'...'}
        breakClassName={'break-me'}
        pageCount={totalPages}
        marginPagesDisplayed={2}
        pageRangeDisplayed={5}
        onPageChange={handlePageClick}
        containerClassName={'pagination'}
        subContainerClassName={'pages pagination'}
        activeClassName={'active'}
      />
    </div>
  );
};

export default SearchResult;
