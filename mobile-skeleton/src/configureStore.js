import { createStore, applyMiddleware } from 'redux';
import createSagaMiddleware from 'redux-saga';
import { composeWithDevTools } from 'redux-devtools-extension';
import createReducer from './reducers/rootReducer.js';
import rootSaga from './sagas/rootSaga';
// Redux persist
import { persistStore, persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';

const persistConfig = {
  key: 'root',
  storage: storage,
  blacklist: ['redirect'],
};

const persistedReducer = persistReducer(persistConfig, createReducer());

/** Store Reducer.
 * @param {Object} initialState - Initial state
 * @return {Object} - return store
 */
export default function configureStore(initialState = []) {
  const sagaMiddleware = createSagaMiddleware();
  const middlewares = [sagaMiddleware];

  const store = createStore(
    persistedReducer,
    composeWithDevTools(applyMiddleware(...middlewares)),
  );
  const persistor = persistStore(store);

  sagaMiddleware.run(rootSaga);

  return [store, persistor];
}
