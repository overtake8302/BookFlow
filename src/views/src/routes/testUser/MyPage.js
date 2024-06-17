import React from 'react';
import { Box, VStack, Button, HStack, Icon, useToast } from '@chakra-ui/react';
import { FaUser, FaShoppingCart, FaSignOutAlt } from 'react-icons/fa';
import { useHistory } from 'react-router-dom';
import withLoginCheck from '../../components/loginCheck/withLoginCheck';
import HomeHeader from '../../components/home/HomeHeader';

const MyPage = () => {

    const token = localStorage.getItem('token');

    const toast = useToast();
    const history = useHistory();

    const handleUserInfo = () => {

        history.push('/user-info');
    };

    const handleOrderList = () => {

        history.push('/order-list');
    };

    const handleSignOut = async () => {
        try {
          const response = await fetch('/api/user', {
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json',
              'access': token
            },
          });
    
          if (!response.ok) {
            throw new Error('탈퇴 실패');
          }
    
          toast({
            title: '회원 탈퇴 성공',
            description: '그동안 함께해서 즐거웠어요. 다시 함께할날을 기다리고 있을게요.',
            status: 'success',
            duration: 9000,
            isClosable: true,
          });
    
          history.push('/login');
        } catch (error) {
          toast({
            title: '회원 탈퇴 처리 중 문제가 발생했어요.',
            description: '회원 탈퇴 처리 중 문제가 발생했어요.',
            status: 'error',
            duration: 9000,
            isClosable: true,
          });
        }
      };

    return (
        <Box p={5}>
        <HomeHeader />
        <Box mt="5%">
            <VStack spacing={4} align="center">
            <HStack w="full" justifyContent="center" alignItems="center">
            <Icon as={FaUser} boxSize="11%" />
            <Button w="33%" colorScheme="blue" onClick={handleUserInfo}>
                회원 정보 조회/수정
            </Button>
            </HStack>
            <HStack w="full" justifyContent="center" alignItems="center">
            <Icon as={FaShoppingCart} boxSize="11%" />
            <Button w="33%" colorScheme="green" onClick={handleOrderList}>
                주문 조회
            </Button>
            </HStack>
            <HStack w="full" justifyContent="center" alignItems="center">
            <Icon as={FaSignOutAlt} boxSize="11%" />
            <Button w="33%" colorScheme="red" onClick={handleSignOut}>
                회원 탈퇴
            </Button>
            </HStack>
        </VStack>
        </Box>
        
        </Box>
    );
};

export default withLoginCheck(MyPage);
