import axios from 'axios';
import { GET_CARS_SERVICE } from './config';

export const api = {
  getCars: async function(accessToken) {
    return axios.get(GET_CARS_SERVICE, {});
  },
};
