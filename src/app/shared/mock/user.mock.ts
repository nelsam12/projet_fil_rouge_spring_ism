import {User} from '../models/user.model';

export const MOCK_USER: User[] = [
  {
    id: 1,
    name: 'Ndiaye',
    login: 'client@gmail.com',
    password: 'client@123',
    role: 'Client'
  },
  {
    id: 2,
    name: 'Fall',
    login: 'admin@gmail.com',
    password: 'admin@123',
    role: 'Admin'
  }
]
