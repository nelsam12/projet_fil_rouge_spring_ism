import { Component } from '@angular/core';
import {AuthentificationMockService} from '../../../shared/services/impl/authentification-mock.service';

@Component({
  selector: 'ism-client',
  imports: [],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent {
  constructor(public authService: AuthentificationMockService) {
  }
}
