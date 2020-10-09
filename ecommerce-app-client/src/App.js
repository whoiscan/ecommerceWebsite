import React from 'react';
import {connect} from 'react-redux'
import axios from 'axios'
import {setProducts} from './actions/poducts'
import Menu from './components/menu'
import Product from './components/product'
import {CardGroup, Container, Row, Col} from 'react-bootstrap';



class App extends React.Component {
    componentDidMount() {
        const {setBooks} = this.props;
        axios.get("/products.json")
            .then(function (response) {
                setBooks(response.data);
            })
    }

    render() {
        const products = this.props.prods.items;
        const cartProducts = this.props.cart.items;
        const {isReady} = this.props.prods;
        let list = [];
        if (products != null) {
            for (let i = 0; i < products.length; i++) {
                if (i + 3 <= products.length) {
                    list.push(
                        <CardGroup><Row className='col-md-16'>
                            <Col className='col-md-4'> <Product product={products[i]}/></Col>
                            <Col className='col-md-4'> <Product product={products[i + 1]}/></Col>
                            <Col className='col-md-4'> <Product product={products[i + 2]}/></Col>
                        </Row></CardGroup>
                    )
                    i += 3;
                }
                else if (i + 2 <= products.length) {
                    list.push(<CardGroup> <Row className='col-md-16'>
                            <Col className='col-md-6'> <Product product={products[i]}/></Col>
                            <Col className='col-md-6'> <Product product={products[i + 1]}/></Col>
                        </Row></CardGroup>
                    )
                    i += 2;
                } else if (i + 1 < products.length) {
                    list.push(<CardGroup> <Row className='col-md-12'>
                            <Col className='col-md-12'><Product product={products[i]}/></Col>
                        </Row></CardGroup>
                    )
                    i += 2;
                }
            }
        }
        return (
            <Container>
                <Menu cartProducts={cartProducts}/>
                <CardGroup>
                    <Col className='col-md-10'>
                        {!isReady ? 'Yuklanmoqda' : list.map(product => {
                            return (
                                product
                            )
                        })}   </Col><Col className='col-md-2'>
                    {/*<Cart products={cartProducts}/>*/}
                </Col>


                </CardGroup>
            </Container>
        );
    }

}

const mapStateToProps = state => ({...state})

const mapDispatchToProps = dispatch => ({
    setBooks: products => dispatch(setProducts(products))
})

export default connect(mapStateToProps, mapDispatchToProps)(App);
