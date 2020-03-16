import { CREATE_CAR_SUCCESS, CREATE_CAR_ERROR } from '../containers/Home/types';

/** Store states
 * @constant {Object} */
export const initialState = {
  createCarError: '',

};

/** Create Car reducer.
 * @param {Object} state - Initial state 
 * @param {Object} action - Payload object
 * @return {Object} - return new state
 */
function editCarReducer(state = initialState, action) {
  switch (action.type) {
    
    /** Action Creator - createCar
    * it will receive response message 
    */
    case CREATE_CAR_SUCCESS:
      return {
        ...state,
        createCarError:'',
      };

    /** Action Creator - create cars failed 
    * it will receive the error message  dispatching from the saga
    */
    case CREATE_CAR_ERROR:
      return {
        ...state,
        createCarError: action.payload,
      };

    default:
      return state;
  }
}

export default editCarReducer;
