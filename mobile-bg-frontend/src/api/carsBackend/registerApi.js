import axios from 'axios';
import { REGISTER_SERVICE_URL } from './config';

export const api = {
  register: async function(firstName,lastName,password,username) {
    return axios.post(REGISTER_SERVICE_URL, {
      firstName,
      lastName,
      password,
      username
    });
  },
};
