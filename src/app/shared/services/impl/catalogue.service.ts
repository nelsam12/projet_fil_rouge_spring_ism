import { Injectable } from '@angular/core';
import {ProduitCatalogue} from '../../models/catalogue.model';
import {ICatalogueService} from '../ICatalogueService';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

// Singleton + Injection de dépendance
@Injectable({
  providedIn: 'root' //
})
export class CatalogueService implements ICatalogueService{


  getProductsCatalogues(): Observable<ProduitCatalogue[]> {
    return this.httpClient.get<ProduitCatalogue[]>("http://localhost:8080/api/produits");
  }

  produits : ProduitCatalogue[] = [
    {
      id : 1,
      name : "Produit1",
      oldPrice : 500,
      newPrice : 440,
      notation: 5,
      image : "https://dummyimage.com/450x300/dee2e6/6c757d.jpg",
      sold : true
    },
    {
      id : 2,
      name : "Produit2",
      oldPrice : 550,
      newPrice : 460,
      notation: 3,
      image : "https://dummyimage.com/450x300/dee2e6/6c757d.jpg",
      sold : false
    },
    {
      id : 3,
      name : "Produit3",
      oldPrice : 800,
      newPrice : 750,
      notation: 5,
      image : "https://dummyimage.com/450x300/dee2e6/6c757d.jpg",
      sold : true
    }
  ];
  constructor(private httpClient: HttpClient) { }
}
