import "./CartHeader.css";
import {ChakraProvider, Stack, Checkbox, Text, Button, Divider} from '@chakra-ui/react';

function CartHeader({userName, cart, setCart}){
    const  cartName = `cart-${userName}`;

    const updateCart = (newCart) => {
        setCart(newCart);
        localStorage.setItem(cartName, JSON.stringify(newCart));
    };

    //전체선택
    const selectAllBooks = (event) => {
        const isChecked = event.target.checked;
        const newCart = (cart.map((book) => ({
                ...book, checked: isChecked
        })));
        updateCart(newCart);
    };

    //선택삭제
    const deleteCheckedBooks = () => {
        const newCart = cart.filter((book) => !book.checked);
        updateCart(newCart);
        alert("선택한 책이 삭제되었습니다.");
    };

    //전체삭제
    const deleteAllBooks = () => {
        // 삭제 코드
        setCart([]);
        localStorage.setItem(`cart-${userName}`,JSON.stringify([]));
        alert("모든 책이 삭제되었습니다.");
    };

    return (
        <ChakraProvider>
            <div className="cartHeader">
                <Text as='b' fontSize='4xl'>장바구니</Text>
                <div className="check-delete">
                    <Stack spacing={2} direction='row' alignItems='center'>
                        <Checkbox
                            colorScheme='blue'
                            isChecked={cart.every((book) => book.checked)}
                            onChange={selectAllBooks}
                            size='md'
                            fontSize='md'
                            fontWeight='normal'
                        >
                            전체선택
                        </Checkbox>
                        <Stack className="delete" direction='row' spacing={2} align='center' ml='auto'>
                            <Button colorScheme='black' fontWeight='normal' variant='link' size='md' onClick={deleteCheckedBooks}>
                                선택삭제
                            </Button>
                            <Divider height='10px' borderColor='gray.600' orientation='vertical' />
                            <Button colorScheme='black' fontWeight='normal' variant='link' size='md' onClick={deleteAllBooks}>
                                전체삭제
                            </Button>
                        </Stack>
                    </Stack>
                </div>
            </div>
        </ChakraProvider>
    );
}

export default CartHeader;