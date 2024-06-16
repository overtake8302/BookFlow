import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Box, List, ListItem, Image, Text, Button, Flex, Heading } from '@chakra-ui/react';
import withAdminCheck from '../../components/adminCheck/withAdminCheck';

function BooksByAdmin({ match }) {
  const [books, setBooks] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const [booksPerPage] = useState(10); // 한 페이지에 표시할 책의 수
  const [totalPages, setTotalPages] = useState(0);
  const categoryId = match.params.categoryId;

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        const response = await fetch(`${process.env.REACT_APP_API_URL}/api/books/category/${categoryId}?page=${currentPage}&size=${booksPerPage}`);
        const data = await response.json();
        setBooks(data.bookMainDtoList);
        setTotalPages(data.totalPages);
      } catch (error) {
        console.error('책 목록을 가져오는 중 에러가 발생했습니다:', error);
      }
    };

    fetchBooks();
  }, [categoryId, currentPage, booksPerPage]);

  // 페이지네이션 컨트롤러
  
  const pageNumbers = [];
  for (let i = 1; i <= Math.ceil(totalPages / booksPerPage); i++) {
    pageNumbers.push(i);
  }

  return (
    <Box p={5}>
      <Heading as="h2" size="xl" mb={6}>[관리자]<br/><br/>책 목록</Heading>
      <List spacing={3}>
        {books.map(book => (
          <ListItem key={book.id} p={3} boxShadow="md" borderRadius="md">
            <Link to={`/admin/book/${book.id}`}>
            <Flex align="center" justify="space-between">
              <Box flexShrink={0}>
                <Image
                  borderRadius="md"
                  src={book.bookImgDtoList && book.bookImgDtoList.length > 0 ? book.bookImgDtoList[0].imgUrl : 'fallback-image-url'}
                  alt={book.bookName}
                  boxSize="100px"
                  objectFit="cover"
                />
              </Box>
              <Box flex="1" ml={4}>
                  <Text fontSize="lg" fontWeight="bold">{book.bookName}</Text>
                <Text>재고 : {book.stock}권</Text>
              </Box>
              
            </Flex>
            </Link>
          </ListItem>
        ))}
      </List>
      <Flex mt={4} justify="center">
        {pageNumbers.map(number => (
          <Button
            key={number}
            onClick={() => setCurrentPage(number - 1)}
            mx={1}
            colorScheme="teal"
            variant="outline"
          >
            {number}
          </Button>
        ))}
      </Flex>
    </Box>
  );
}

export default withAdminCheck(BooksByAdmin);
