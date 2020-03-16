import { GET_CARS_SUCCESS, GET_CARS_ERROR } from '../containers/Home/types';

/** Store states
 * @constant {Object} */
export const initialState = {
  getCarsError: '',
  cars:[],

};

/** Get Cars reducer.
 * @param {Object} state - Initial state 
 * @param {Object} action - Payload object
 * @return {Object} - return new state
 */
function getCarsReducer(state = initialState, action) {
  switch (action.type) {
    
    /** Action Creator - getCars
    * it will receive cars from the saga
    */
    case GET_CARS_SUCCESS:
      return {
        ...state,
        cars: action.payload.cars,
        getCarsError:'',
      };

    /** Action Creator - Get cars failed 
    * it will receive the error message  dispatching from the saga
    */
    case GET_CARS_ERROR:
      return {
        ...state,
        getCarsError: action.payload,
        
      };

    default:
      return state;
  }
}

export default getCarsReducer;
