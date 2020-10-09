import React from 'react';
import {Button, Card, Row} from "react-bootstrap";


export default class Product extends React.Component{
    render() {
        const {product} = this.props
        return (

            <Card style={{width: '18rem'}} key={product.id}>
                <Card.Img variant="top" src={product.img}/>
                <Card.Body>
                    <Card.Title>{product.name}</Card.Title>
                    <Card.Text>
                        {product.price}
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                </Card.Body>
            </Card>

        )
    }
}