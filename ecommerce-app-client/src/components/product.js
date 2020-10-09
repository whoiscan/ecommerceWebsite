import React from 'react';
import {connect} from 'react-redux';
import {Button, Card, Row} from "react-bootstrap";
import {addToCart, deleteFromCart} from "../actions/cart";


class Product extends React.Component{
    render() {
        const {product,addToCart} = this.props
        return (
            <Card style={{width: '18rem'}} key={product.id}>
                <Card.Img variant="top" src={product.img}/>
                <Card.Body>
                    <Card.Title>{product.name}</Card.Title>
                    <Card.Text>
                        {product.price}
                    </Card.Text>
                    <Button variant="primary" onClick={addToCart.bind(this,product)}>Add to cart</Button>
                </Card.Body>
            </Card>
        )
    }
}

const mapDispatchToProps=dispatch=>({
    addToCart: product=>dispatch(addToCart(product))
})
export default connect(null,mapDispatchToProps)(Product)