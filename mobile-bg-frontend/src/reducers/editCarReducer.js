import { EDIT_CAR_SUCCESS, EDIT_CAR_ERROR } from '../containers/Home/types';

/** Store states
 * @constant {Object} */
export const initialState = {
  editCarsError: '',

};

/** Edit Car reducer.
 * @param {Object} state - Initial state 
 * @param {Object} action - Payload object
 * @return {Object} - return new state
 */
function editCarReducer(state = initialState, action) {
  switch (action.type) {
    
    /** Action Creator - editCar
    * it will receive response message 
    */
    case EDIT_CAR_SUCCESS:
      return {
        ...state,
        editCarsError:'',
      };

    /** Action Creator - Edit cars failed 
    * it will receive the error message  dispatching from the saga
    */
    case EDIT_CAR_ERROR:
      return {
        ...state,
        editCarsError: action.payload,
      };

    default:
      return state;
  }
}

export default editCarReducer;
