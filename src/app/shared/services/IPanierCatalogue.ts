import {Observable} from 'rxjs';
import {ProduitDetail, ProduitCatalogue} from '../models/catalogue.model';

export interface IPanierCatalogue {
  addProduct(produit: ProduitCatalogue) : void;
  deleteProduct(produit: ProduitCatalogue) : void;
  clearCart() : void;

}
