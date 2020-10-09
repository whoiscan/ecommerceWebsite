import React from 'react';
import {connect} from 'react-redux'
import App from '../App'
import {setProducts} from '../actions/poducts'


const mapStateToProps = state => ({...state})

const mapDispatchToProps=dispatch=>({
    setBooks:products=>dispatch(setProducts(products))
})

export default connect(mapStateToProps, mapDispatchToProps)(App);
