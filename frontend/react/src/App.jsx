import {Spinner, Text, Wrap, WrapItem} from '@chakra-ui/react'
import SidebarWithHeader from "./components/shared/Sidebar.jsx";
import {useEffect, useState} from 'react';
import {getCustomers} from "./services/client.js";
import CardWithImage from "./components/Card.jsx";
import {getRandomUsers} from "./services/getRandomCustomers.js";

const App = () => {

    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        getCustomers().then(res => {
            setCustomers(res.data)
        }).catch(err => {
            console.log(err);
        }).finally(() => {
            setLoading(false)
        })

    }, []);



    if (loading) {
        return (<SidebarWithHeader>
            <Spinner thickness={'4px'} speed={'0.65s'} emptyColor={'gray.200'} color={'blue.500'} size={'xl'}/>
        </SidebarWithHeader>)
    }

    if (customers.length <= 0) {
        return (
            <SidebarWithHeader>
                <Text>No Customers available</Text>
            </SidebarWithHeader>
        )

    }

    return (
        <SidebarWithHeader>
            <Wrap justify={"center"} spacing={"30px"}>
                {customers.map((customer, index) => (
                    <WrapItem key={index}>
                        <CardWithImage  {...customer}/>
                    </WrapItem>
                ))}
            </Wrap>
        </SidebarWithHeader>

    )
}

export default App