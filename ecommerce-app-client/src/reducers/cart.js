const initiailState = {
    items: [],
    count: 0
}
export const cart = (state = initiailState, action) => {
    console.log(state.items);
    switch (action.type) {
        case 'ADD_PRODUCT_TO_CART':
            return {
                items: state.items.concat(action.payload),
                count: state.count + 1

            }
        case 'DELETE_PRODUCT_FROM_CART':
            return {
                ...state,
                items: state.items.filter(product => {
                    return product.id != action.payload
                }),
                count: state.count - 1
            }
        default:
            return state
    }
}