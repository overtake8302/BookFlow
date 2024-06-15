import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import { Box, List, ListItem, ListIcon, Heading } from '@chakra-ui/react';
import { MdCheckCircle } from 'react-icons/md';

function CategoriesByAdmin() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data))
      .catch(error => console.error('카테고리를 가져오는 중 에러가 발생했습니다:', error));
  }, []);

  return (
    <Box className="category-container" p={5} width="100%">
      <Heading as="h2" size="lg" mb={4}>
        *관리자 책조회*<br/>책을 조회할 카테고리를 선택해 주세요.
      </Heading>
      <List spacing={3}>
        {categories.map(category => (
          <ListItem key={category.id} fontSize="lg">
            <ListIcon as={MdCheckCircle} color="green.500" />
            <Link to={`/admin/books/category/${category.id}`}>{category.categoryName}</Link>
          </ListItem>
        ))}
      </List>
    </Box>
  );
}

export default CategoriesByAdmin;