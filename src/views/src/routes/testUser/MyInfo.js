import React, { useState, useEffect } from 'react';
import {
  Box,
  FormControl,
  FormLabel,
  Input,
  Button,
  Heading,
  useToast,
  FormErrorMessage
} from '@chakra-ui/react';
import HomeHeader from '../../components/home/HomeHeader';
import withLoginCheck from '../../components/loginCheck/withLoginCheck';

function MyInfo() {
  const token = localStorage.getItem('token');
  const toast = useToast();

  const [profile, setProfile] = useState({
    password: '',
    confirmPassword: '',
    name: '',
    phoneNumber: '',
    postalCode : '',
    address1: '',
    address2: '',
  });

  const [errors, setErrors] = useState({});

  useEffect(() => {

    fetch(`${process.env.REACT_APP_API_URL}/api/user/member`, {
      method: 'GET',
      headers: {
        'access': token,
      }
    })
    .then(response => response.json())
    .then(data => {
      setProfile(prevProfile => ({
        ...prevProfile,
        name: data.name || '',
        phoneNumber: data.phoneNumber || '',
        postalCode: data.orderDeliveryPostalCode || '',
        address1: data.orderDeliveryAddress1 || '',
        address2: data.orderDeliveryAddress2 || '',
      }));
    })
    .catch(error => console.error('Error:', error));
  }, [token]);

  console.log(profile);

  const validateForm = () => {
    let valid = true;
    let errors = {};


    if (!profile.password) {
      errors.password = "비밀번호를 입력해 주세요.";
      valid = false;
    } else if (profile.password !== profile.confirmPassword) {
      errors.confirmPassword = "비밀번호가 일치하지 않아요.";
      valid = false;
    }

    if (!profile.name) {
      errors.name = "이름을 입력해 주세요.";
      valid = false;
    }

    if (!profile.phoneNumber) {
      errors.phoneNumber = "전화번호를 입력해 주세요.";
      valid = false;
    } else if (!/^\d+$/.test(profile.phoneNumber)) {
      errors.phoneNumber = "전화번호는 숫자만 입력 할 수 있어요.";
      valid = false;
    }

    if (!profile.postalCode) {
      errors.postalCode = "우편번호를 입력해 주세요.";
      valid = false;
    }

    if (!profile.address1) {
      errors.address1 = "주소를 입력해 주세요.";
      valid = false;
    }

    if (!profile.address2) {
      errors.address2 = "상세주소를 입력해 주세요.";
      valid = false;
    }

    setErrors(errors);
    return valid;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProfile(prevProfile => ({
      ...prevProfile,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!validateForm()) {
      return;
    }

    fetch(`${process.env.REACT_APP_API_URL}/api/user/member`, {
      method: 'PUT',
      headers: {
        'access': token,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(
        {
          password: profile.password,
          name: profile.name,
          phoneNumber: profile.phoneNumber,
          orderDeliveryPostalCode : profile.postalCode,
          orderDeliveryAddress1 : profile.address1,
          orderDeliveryAddress2 : profile.address2
        }
      )
    })
    .then((response) => {
      if (!response.ok) {
        throw new Error("회원 정보 수정 실패");
      }
      return response;
    })
    .then(() => {
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
        description: error.message,
        status: 'error',
        duration: 9000,
        isClosable: true,
      });
    });
  };

  return (
    <Box mx="auto" maxW="80%" >
      <HomeHeader/>
      <Heading mt="50px" mb='20px' as="h2" fontSize="2em" fontWeight="bold">내정보 수정</Heading>
      <form onSubmit={handleSubmit}>
        <FormControl id="password" isInvalid={errors.password} isRequired>
          <FormLabel>비밀번호</FormLabel>
          <Input type="password" name="password" value={profile.password} onChange={handleChange} />
          <FormErrorMessage>{errors.password}</FormErrorMessage>
        </FormControl>
        <FormControl id="confirmPassword" isInvalid={errors.confirmPassword} isRequired>
          <FormLabel>비밀번호 확인</FormLabel>
          <Input type="password" name="confirmPassword" value={profile.confirmPassword} onChange={handleChange} />
          <FormErrorMessage>{errors.confirmPassword}</FormErrorMessage>
        </FormControl>
        <FormControl id="name" isInvalid={errors.name} isRequired>
          <FormLabel>이름</FormLabel>
          <Input type="text" name="name" value={profile.name} onChange={handleChange} />
          <FormErrorMessage>{errors.name}</FormErrorMessage>
        </FormControl>
        <FormControl id="phoneNumber" isInvalid={errors.phoneNumber} isRequired>
          <FormLabel>전화번호</FormLabel>
          <Input type="tel" name="phoneNumber" value={profile.phoneNumber} onChange={handleChange} />
          <FormErrorMessage>{errors.phoneNumber}</FormErrorMessage>
        </FormControl>
        <FormControl id="postalCode" isInvalid={errors.postalCode} isRequired>
          <FormLabel>우편번호</FormLabel>
          <Input type="number" name="postalCode" value={profile.postalCode} onChange={handleChange} />
          <FormErrorMessage>{errors.postalCode}</FormErrorMessage>
        </FormControl>
        <FormControl id="address1" isInvalid={errors.address1} isRequired>
          <FormLabel>주소</FormLabel>
          <Input type="text" name="address1" value={profile.address1} onChange={handleChange} />
          <FormErrorMessage>{errors.address1}</FormErrorMessage>
        </FormControl>
        <FormControl id="address2" isInvalid={errors.address2} isRequired>
          <FormLabel>상세주소</FormLabel>
          <Input type="text" name="address2" value={profile.address2} onChange={handleChange} />
          <FormErrorMessage>{errors.address2}</FormErrorMessage>
        </FormControl>
        <Button mt={4} colorScheme="teal" type="submit">내정보 수정 하기</Button>
      </form>
    </Box>
  );
}

export default withLoginCheck(MyInfo);
