import React from 'react'
import {connect} from 'react-redux';
import {DropdownButton, Dropdown} from 'react-bootstrap'
import {deleteFromCart} from "../actions/cart";



class Cart extends React.Component{
    render(){
        const {products,deleteFromCart,count}=this.props;
        const title="Korzina ("+count+")";
        return <DropdownButton id="dropdown-basic-button" title={title}>
            {products.map(product=>{
                return <Dropdown.Item>
                   <div><button onClick={deleteFromCart.bind(this,product.id)}>x</button>{product.name}</div>
                    <div>{product.price}</div>
                    </Dropdown.Item>
            })}
        </DropdownButton>
    }
}
const mapStateToProps=({cart})=>({items:cart.items,count:cart.count})
const mapDispatchToProps=dispatch=>({
    deleteFromCart: id=>dispatch(deleteFromCart(id))
})
export default connect(mapStateToProps,mapDispatchToProps)(Cart)