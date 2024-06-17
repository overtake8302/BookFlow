import React, { useState, useEffect } from 'react';
import {
  Box,
  FormControl,
  FormLabel,
  Input,
  Button,
  Heading,
  useToast
} from '@chakra-ui/react';

function MyInfo() {

    const token = localStorage.getItem('token');

    const toast = useToast();

    const [profile, setProfile] = useState({
        username: '',
        name: '',
        phoneNumber: '',
        address: ''
    });

  useEffect(() => {
    // 경수님 백엔드 수정후 거기에 맞게 수정 (내정보 get)
    fetch('API_ENDPOINT', {
      method: 'GET',
      headers: {
        'access': token, 
      }
    })
    .then(response => response.json())
    .then(data => setProfile(data))
    .catch(error => console.error('Error:', error));
  }, []);

  function handleChange(e) {
    const { name, value } = e.target;
    setProfile(prevProfile => ({
      ...prevProfile,
      [name]: value
    }));
  }

  function handleSubmit(e) {
    e.preventDefault();
    // 경수님 수정하시면 여기도 맟춰서 수정하기 회원 정보 수정 put
    fetch('API_ENDPOINT', {
      method: 'PUT',
      headers: {
        'access': token,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(profile)
    })
    .then((response) => {

        if (!response.ok) {
            throw new Error("회원 정보 수정 실패");
        }
        response.json()
    })
    .then((data) => {
        toast({
            title: '내정보를 수정했어요.',
            description: "내정보를 수정했어요.",
            status: 'success',
            duration: 9000,
            isClosable: true,
          });
    })
    .catch((error) => {

        toast({
            title: '내정보 수정을 실패했어요.',
            description: '내정보 수정을 실패했어요.',
            status: 'error',
            duration: 9000,
            isClosable: true,
          });
    });
  }

  return (
    <Box p={4}>
        <Heading mb='20px' as="h2" fontSize="2em" fontWeight="bold">내정보 수정</Heading>
        <form onSubmit={handleSubmit}>
            <FormControl id="username">
            <FormLabel>닉네임</FormLabel>
            <Input type="text" name="username" value={profile.username} onChange={handleChange} />
            </FormControl>
            <FormControl id="name">
            <FormLabel>이름</FormLabel>
            <Input type="text" name="name" value={profile.name} onChange={handleChange} />
            </FormControl>
            <FormControl id="phoneNumber">
            <FormLabel>휴대전화 번호</FormLabel>
            <Input type="tel" name="phoneNumber" value={profile.phoneNumber} onChange={handleChange} />
            </FormControl>
            <FormControl id="address">
            <FormLabel>주소</FormLabel>
            <Input type="text" name="address" value={profile.address} onChange={handleChange} />
            </FormControl>
            <Button mt={4} colorScheme="teal" type="submit">내정보 수정 하기</Button>
        </form>
        </Box>
  );
}

export default MyInfo;
