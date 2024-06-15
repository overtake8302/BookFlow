import React, { useState, useEffect } from 'react';
import { useParams, useHistory, Link } from 'react-router-dom';
import {
  Box,
  FormControl,
  FormLabel,
  Input,
  Textarea,
  Select,
  Button,
  VStack,
  Heading,
  useToast
} from '@chakra-ui/react';

const BookAdminPage = () => {
    const { bookId } = useParams(); 
    const history = useHistory();
    const token = localStorage.getItem('token');
    const [bookForm, setBookForm] = useState({
        id: null,
        name: '',
        detail: '',
        price: '',
        stock: '',
        date: '',
        categoryId: '',
        bookImgFiles: []
    });
    const [categories, setCategories] = useState([]);

    const toast = useToast();

  useEffect(() => {
    const fetchCategories = async () => {
      const response = await fetch('http://localhost:8080/api/categories');
      const data = await response.json();
      setCategories(data);
    };

    fetchCategories();
  }, []);

  useEffect(() => {
    if (bookId) {
      const fetchBookDetails = async () => {
        try {
          const response = await fetch(`http://localhost:8080/api/book/${bookId}`);
          const data = await response.json();
          setBookForm(prevBookForm => ({
            ...prevBookForm,
            id: data.id,
            name: data.name,
            detail: data.detail,
            price: data.price,
            stock: data.stock,
            date: data.date,
            categoryId: data.categoryId
          }));
        } catch (error) {
          console.error('책 정보를 가져오는 중 에러가 발생했습니다:', error);
        }
      };
      fetchBookDetails();
    }
  }, [bookId]);
  

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setBookForm({ ...bookForm, [name]: value });
  };

  const handleFileChange = (e) => {
    setBookForm({ ...bookForm, bookImgFiles: [...e.target.files] });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    Object.keys(bookForm).forEach(key => {
      if (key !== 'bookImgFiles') {
        formData.append(key, bookForm[key]);
      }
    });
    bookForm.bookImgFiles.forEach(file => {
      formData.append('images', file);
    });

    try {
        const url = bookForm.id ? `http://localhost:8080/api/admin/book/${bookForm.id}` : 'http://localhost:8080/api/admin/book';
        const response = await fetch(url, {
          method: bookForm.id ? 'PUT' : 'POST',
          headers: {
            'access': token, 
          },
          body: formData
        });
        toast({
          title: '책정보를 저장했어요.',
          description: "책정보를 저장했어요.",
          status: 'success',
          duration: 9000,
          isClosable: true,
        });
      
        if (!response.ok) {
          throw new Error('책 정보를 저장하는데 문제가 발생했습니다.');
        }
        const data = await response.json();
        console.log('책 정보가 저장되었습니다:', data);
      } catch (error) {
        toast({
          title: '책 저장에 실패 했어요.',
          description: error.toString(),
          status: 'error',
          duration: 9000,
          isClosable: true,
        });
      }
    }
      

    return (
      <Box p={5}>
        <VStack spacing={4} align="stretch">
          <Heading as="h2" size="lg">{bookForm.id ? '책 수정' : '책 추가'}</Heading>
          <form onSubmit={handleSubmit}>
            <FormControl id="category">
              <FormLabel>카테고리</FormLabel>
              <Select name="categoryId" value={bookForm.categoryId} onChange={handleInputChange} placeholder="카테고리를 골라주세요.">
                {categories.map(category => (
                  <option key={category.id} value={category.id}>
                    {category.categoryName}
                  </option>
                ))}
              </Select>
            </FormControl>
  
            <FormControl id="name">
              <FormLabel>책 제목</FormLabel>
              <Input type="text" name="name" value={bookForm.name} onChange={handleInputChange} placeholder="책 이름을 적어주세요." />
            </FormControl>
  
            <FormControl id="detail">
              <FormLabel>책 설명</FormLabel>
              <Textarea name="detail" value={bookForm.detail} onChange={handleInputChange} placeholder="책 설명을 적어주세요." />
            </FormControl>
  
            <FormControl id="price">
              <FormLabel>가격</FormLabel>
              <Input type="number" name="price" value={bookForm.price} onChange={handleInputChange} placeholder="책 가격을 적어주세요." />
            </FormControl>
  
            <FormControl id="stock">
              <FormLabel>재고</FormLabel>
              <Input type="number" name="stock" value={bookForm.stock} onChange={handleInputChange} placeholder="재고수량을 적어주세요." />
            </FormControl>
  
            <FormControl id="date">
              <FormLabel>출판일</FormLabel>
              <Input type="text" name="date" value={bookForm.date} onChange={handleInputChange} placeholder="출판일을 적어주세요." />
            </FormControl>
  
            <FormControl id="file">
              <FormLabel>표지나 사진을 올려주세요.</FormLabel>
              <Input type="file" multiple onChange={handleFileChange} />
            </FormControl>
  
            <Button colorScheme="blue" mt={4} type="submit">
              {bookForm.id ? '책 수정' : '책 추가'}
            </Button>
          </form>
          <Link to='/admin/books'><Button colorScheme='gray'>책 목록</Button></Link>
        </VStack>
      </Box>
    );
  };
  
  export default BookAdminPage;