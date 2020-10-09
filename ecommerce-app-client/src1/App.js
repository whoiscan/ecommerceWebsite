import React from 'react';
import {connect} from 'react-redux'
import axios from 'axios'

import Menu from './components/menu'
import Product from './components/product'
import {Row,CardGroup,Container,Card, Button} from 'react-bootstrap';
import {setProducts} from "./actions/poducts";



export default class App extends React.Component {
    componentDidMount(){
        const {setBooks}=this.props;
        axios.get("/products.json")
            .then(function (response) {
                setBooks( response.data);
            })
    }

    render() {
        const products = this.props.prods.items;
        const {isReady} = this.props.prods;

        return (
            <Container>
                <Menu/>
                 <CardGroup>
                    {!isReady?'Yuklanmoqda': products.map(product => {
                        return (
                            <Row className='col-md-4'>
                              <Product product={product}/>
                            </Row>
                        )
                    })}
                </CardGroup>

            </Container>
        );
    }
}

const mapStateToProps = state => ({...state})

const mapDispatchToProps=dispatch=>({
    setBooks:products=>dispatch(setProducts(products))
})

export default connect(mapStateToProps, mapDispatchToProps)(App);


