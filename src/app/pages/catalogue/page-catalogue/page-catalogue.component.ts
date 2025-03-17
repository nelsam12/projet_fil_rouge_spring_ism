import {Component, inject, OnInit} from '@angular/core';
import {ProduitItemComponent} from '../../../components/catalogue/produit-item/produit-item.component';
import {CatalogueService} from '../../../shared/services/impl/catalogue.service';
import {ProduitCatalogue} from '../../../shared/models/catalogue.model';

@Component({
  selector: 'ism-page-catalogue',
  imports: [
    ProduitItemComponent
  ],
  templateUrl: './page-catalogue.component.html',
  styleUrl: './page-catalogue.component.css'
})
export class PageCatalogueComponent implements OnInit  {

  // constructor(private catalogueService : CatalogueService ) {
  // }
  private catalogueService:CatalogueService = inject(CatalogueService);
  products : ProduitCatalogue[] = [];
  ngOnInit(): void {
    this.catalogueService.getProductsCatalogues().subscribe(
      data => this.products = data,
      error => console.log(error)
    )
    // this.products = this.catalogueService.produits;
  }



}
