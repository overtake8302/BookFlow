import {ChakraProvider, Divider, Stack, Text, Box, Image, Flex} from '@chakra-ui/react';
import {Link} from "react-router-dom";
import defaultImage from '../../resources/book/default book cover.png';

function BookInfoDetail({book, images}){
    const Divider = ({ width, color }) => (
        <div style={{ width: `${width}px`, height: '1px', backgroundColor: color }} />
    );

    return (
        <ChakraProvider>
            <div>
                <Stack spacing={10} direction='column' ml='110px'>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg' fontWeight='bold'> 책 소개 </Text>
                        <Divider width={53} color="darkgray" />
                        <Box maxW='560px'> {/* 최대 너비를 설정 */}
                            <Text fontSize='md' mt={1} whiteSpace="pre-wrap" wordBreak="break-word">
                                {book.book_detail}
                            </Text>
                        </Box>
                    </Stack>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg' fontWeight='bold'> 목차 </Text>
                        <Divider width={35} color="darkgray"/>
                        <ul>
                            {book.book_content && book.book_content.map((content, index) => (
                                <Text key={index} fontSize='md' mt={1}> {content} </Text>
                            ))}
                        </ul>
                    </Stack>
                    <Stack spacing={1} direction='column'>
                        <Text fontSize='lg' fontWeight='bold'> 관련 분류 </Text>
                        <Divider width={66} color="darkgray"/>
                        <Text fontSize='md' mt={1}> {book.book_category} </Text>
                    </Stack>
                    <Stack spacing={2} direction='column'>
                        <Text fontSize='lg' fontWeight='bold'> 상세 사진 </Text>
                        <Divider width={66} color="darkgray" />
                        <Flex justifyContent="center">
                        <Box>
                            {images && images.length > 0 ? (
                            images.map((imgUrl, index) => (
                                <Image
                                mt={5}
                                ml={5}
                                key={index}
                                src={imgUrl}
                                alt={`book image ${index + 1}`}
                                height='500px'
                                width='450px'
                                />
                            ))
                            ) : (
                            <Image src={defaultImage} />
                            )}
                        </Box>
                        </Flex>
                    </Stack>
                </Stack>
            </div>
        </ChakraProvider>
    );
}

export default BookInfoDetail;