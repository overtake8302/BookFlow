import {ChakraProvider, Divider, Stack, Text, Box, Image} from '@chakra-ui/react';
import {Link} from "react-router-dom";

function BookInfoDetail({book, images}){
    const Divider = ({ width, color }) => (
        <div style={{ width: `${width}px`, height: '1px', backgroundColor: color }} />
    );

    return (
        <ChakraProvider>
            <div>
                <Stack spacing={10} direction='column' ml={110}>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg'> 책 소개 </Text>
                        <Divider width={53} color="darkgray" />
                        <Text fontSize='md' mt={1}> {book.book_detail} </Text>
                    </Stack>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg'> 목차 </Text>
                        <Divider width={35} color="darkgray"/>
                        <ul>
                            {book.book_content && book.book_content.map((content, index) => (
                                <Text key={index} fontSize='md' mt={1}> {content} </Text>
                            ))}
                        </ul>
                    </Stack>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg'> 관련 분류 </Text>
                        <Divider width={66} color="darkgray"/>
                        <Text fontSize='md' mt={1}> {book.book_category} </Text>
                    </Stack>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg'> 상세 사진 </Text>
                        <Divider width={66} color="darkgray"/>
                        <Box>
                            {images && images.map((imgUrl, index) => (
                                <Image key={index} src={imgUrl} alt={`book image ${index + 1}`} mb={4} />
                            ))}
                        </Box>
                    </Stack>
                </Stack>
            </div>
        </ChakraProvider>
    );
}

export default BookInfoDetail;