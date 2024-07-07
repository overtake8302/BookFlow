import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Box, List, ListItem, Image, Text, Button, Flex, Heading, Select } from '@chakra-ui/react';
import withAdminCheck from '../../components/adminCheck/withAdminCheck';
import defaultBookCover from '../../resources/book/default book cover.png';
import HomeHeader from '../../components/home/HomeHeader';

function BooksByAdmin() {
  const [books, setBooks] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const [booksPerPage] = useState(10);
  const [totalPages, setTotalPages] = useState(0);
  const [categoryId, setCategoryId] = useState();
  const [categories, setCategories] = useState([]);
  const [pageNumbers, setPageNumbers] = useState([]);


  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await fetch(`${process.env.REACT_APP_API_URL}/api/categories`);
        const data = await response.json();
        setCategories(data);
      } catch (error) {
        console.error('카테고리를 가져오는 중 에러가 발생했습니다:', error);
      }
    };

    fetchCategories();
  }, []);

  useEffect(() => {
    if (categoryId) {
      const fetchBooks = async () => {
        try {
          const response = await fetch(`${process.env.REACT_APP_API_URL}/api/books/category/${categoryId}?page=${currentPage}&size=${booksPerPage}`);
          if (!response.ok) {
            setBooks([]);
            setTotalPages(0);
          }
          const data = await response.json();
          setBooks(data.bookMainDtoList);
          setTotalPages(data.totalPages);
        } catch (error) {
          console.error('책 목록을 가져오는 중 에러가 발생했습니다:', error);
        }
      };
  
      fetchBooks(); 
    }
  }, [categoryId, currentPage, booksPerPage]);

  useEffect(() => {
    const newPageNumbers = [];
    for (let i = 1; i <= totalPages; i++) {
      newPageNumbers.push(i);
    }
    setPageNumbers(newPageNumbers);
  }, [totalPages]);

  useEffect(() => {
    // 책 상세조회후 뒤로가기 할때 보던거 복원용
    const lastPage = localStorage.getItem('lastPage');
    const lastCategoryId = localStorage.getItem('lastCategoryId');
    if (lastPage) {
      setCurrentPage(Number(lastPage));
    }
    if (lastCategoryId) {
      setCategoryId(lastCategoryId);
    }
    // ...
  }, []);

  const handleCategoryChange = (event) => {
    const selectedCategoryId = event.target.value;
    setCategoryId(selectedCategoryId);
    setCurrentPage(0);
    // 로컬 스토리지에 보던 카테고리 저장
    localStorage.setItem('lastCategoryId', selectedCategoryId);
  };

  useEffect(() => {
    // 로컬 스토리지에 보던 페이지 저장
    localStorage.setItem('lastPage', currentPage);
  }, [currentPage]);

  return (
    <Box p={5}>
      <HomeHeader />
      <Box mx="auto" maxW="80%">
        <Heading as="h2" size="xl" mb={6}>[관리자]<br/><br/>책 목록</Heading>
      <Flex mb={5} justify="center" align="center">
        <Select placeholder="카테고리 선택" onChange={handleCategoryChange}  value={categoryId}>
          {categories.map((category) => (
            <option key={category.id} value={category.id}>{category.categoryName}</option>
          ))}
        </Select>
        <Link to='/product/add'>
          <Button m={2} colorScheme='gray'>책 추가</Button>
        </Link>
      </Flex>
      <List spacing={3}>
      {books.length > 0 ? (
          books.map(book => (
      <ListItem key={book.id} p={3} boxShadow="md" borderRadius="md" bg="gray.100">
        <Link to={`/admin/book/${book.id}`}>
          <Flex align="center" justify="space-between" wrap="wrap" p={3} borderRadius="md">
            <Box flexShrink={0}>
              <Image
                borderRadius="md"
                src={book.bookImgDtoList && book.bookImgDtoList.length > 0 ? book.bookImgDtoList[0].imgUrl : defaultBookCover}
                alt={book.bookName}
                boxSize="100px"
                objectFit="cover"
              />
            </Box>
            <Box flex="1" ml={4} my={2}>
              <Flex align="center" justify="space-between">
                <Box bg="teal.100" p={2} borderRadius="md">
                  <Text fontSize="lg" fontWeight="bold" color="teal.800">{book.bookName}</Text>
                </Box>
                <Box bg="orange.100" p={2} borderRadius="md">
                  <Text color="gray.600">카테고리: {book.category.categoryName}</Text>
                </Box>
                <Box bg="yellow.100" p={2} borderRadius="md">
                  <Text color="gray.600">출판사: {book.publisher}</Text>
                </Box>
                <Box bg="green.100" p={2} borderRadius="md">
                  <Text color="gray.600">출판일: {book.date}</Text>
                </Box>
                <Box bg="blue.100" p={2} borderRadius="md">
                  <Text color="gray.600">저자: {book.author}</Text>
                </Box>
                <Box bg="pink.100" p={2} borderRadius="md">
                  <Text color="gray.600">가격: ₩{book.bookPrice}</Text>
                </Box>
                <Box bg="purple.100" p={2} borderRadius="md">
                  <Text color="gray.600">재고: {book.stock}권</Text>
                </Box>
              </Flex>
            </Box>
          </Flex>
        </Link>
      </ListItem>
          ))
    ) : (<Text>선택한 카테고리에 책이 없어요.</Text>)}
      </List>
        <Flex mt={4} justify="center">
        {pageNumbers.map(number => (
          <Button
            key={number}
            onClick={() => setCurrentPage(number - 1)}
            mx={1}
            colorScheme="teal"
            variant={currentPage === number - 1 ? "solid" : "outline"}
          >
            {number}
          </Button>
        ))}
      </Flex>
      </Box>
      
    </Box>
  );
}

export default withAdminCheck(BooksByAdmin);
