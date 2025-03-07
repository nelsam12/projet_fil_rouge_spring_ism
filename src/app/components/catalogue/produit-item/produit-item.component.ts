import {Component, Input} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {ProduitCatalogue} from '../../../shared/models/catalogue.model';

@Component({
  selector: 'ism-produit-item',
  imports: [

  ],
  templateUrl: './produit-item.component.html',
  styleUrl: './produit-item.component.css'
})
export class ProduitItemComponent {
  @Input({alias : "produits", required: true}) produit!: ProduitCatalogue;

  // Injection de dépendance
  constructor(private router : Router) {
  }

  onLoadViewDetail(id : number) {
    this.router.navigateByUrl(`/catalogue/detail/${id}`);
  }

  protected readonly Array = Array;
}
