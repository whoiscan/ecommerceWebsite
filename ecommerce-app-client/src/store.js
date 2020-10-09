import {createStore, applyMiddleware} from 'redux'
import rootReducer from './reducers/index'
import logger from 'redux-logger'

export default ()=> {
    const store=createStore(rootReducer,applyMiddleware(logger));
    return store;
}