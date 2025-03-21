import { Component } from '@angular/core';
import {PanierService} from '../../../shared/services/impl/panier.service';
import {TruncatePipe} from '../../../shared/pipes/truncate.pipe';
import {Router, RouterLink} from '@angular/router';
import {AuthentificationMockService} from '../../../shared/services/impl/authentification-mock.service';

@Component({
  selector: 'ism-panier-catalogue',
  imports: [
    TruncatePipe,
    RouterLink
  ],
  templateUrl: './panier-catalogue.component.html',
  styleUrl: './panier-catalogue.component.css'
})
export class PanierCatalogueComponent {

  constructor(public panierService: PanierService, private router: Router) {
  }

}
