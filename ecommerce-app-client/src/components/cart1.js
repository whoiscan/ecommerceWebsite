import React from 'react'
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import {setProduct} from "../actions/cart";
import {connect} from "react-redux";

class Cart1 extends React.Component {
    constructor(props) {
        super(props);
        this.onClickDelete = this.onClickDelete.bind(this);
    }


    onClickDelete(event) {

        const {setBooks} = this.props;
        setBooks(this.props.selectedProduct);


    }


    render() {
        let {selectedProduct} = this.props;

        return





        {/*<Card style={{width: '18rem'}}>*/}

            {/*<Card.Body>*/}
                {/*<Card.Title>{selectedProduct.name}</Card.Title>*/}
                {/*<Card.Text>*/}
                    {/*{selectedProduct.price}*/}
                {/*</Card.Text>*/}
                {/*<Button variant="danger" onClick={this.onClickDelete}>Go somewhere</Button>*/}
            {/*</Card.Body>*/}
        {/*</Card>*/}

    }


}

const mapStateToProps = state => ({...state});

const mapDispatchToProps = dispatch => ({
    setBooks: product => dispatch(setProduct(false, product))
})
export default connect(mapStateToProps, mapDispatchToProps)(Cart1);
