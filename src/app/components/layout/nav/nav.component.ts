import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import {PanierService} from '../../../shared/services/impl/panier.service';
import {PanierCatalogue} from '../../../shared/models/catalogue.model';


@Component({
  selector: 'app-nav',
  imports: [RouterModule],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

  protected links: Link[] = [
    { name: 'Catalogue', path: '/catalogue', class:"nav-link", ariaCurrent: 'page'},
  ];

  constructor(public panierService: PanierService) {

  }
}

interface Link {
  name: string;
  path: string;
  class : string; // Optionnel
  subLinks?: Array<Link>; // Optionnel
  ariaCurrent?: string; // Optionnel
}
