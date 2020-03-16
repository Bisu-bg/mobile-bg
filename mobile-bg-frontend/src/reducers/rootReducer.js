import { combineReducers } from 'redux';
import userSessionReducer from './userSessionReducer';
import createCarReducer from './createCarReducer';
import editCarReducer from './editCarReducer';
import getCarsReducer from './getCarsReducer';
import registerReducer from './registerReducer';
import removeCarReducer from './removeCarReducer';
import redirectReducer from './redirectReducer';


/** Combine all reducers
 * @returns {Object} store
 */
export default function createReducer() {
  const rootReducer = combineReducers({
    userSession: userSessionReducer,
    redirect: redirectReducer,
    createCar: createCarReducer,
    editCar: editCarReducer,
    getCars: getCarsReducer,
    register: registerReducer,
    removeCar: removeCarReducer,
  });
  return rootReducer;
}
