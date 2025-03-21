import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CatalogueService } from '../../../shared/services/impl/catalogue.service';
import { ProduitDetail } from '../../../shared/models/catalogue.model';
import { ProduitItemComponent } from "../components/catalogue/produit-item/produit-item.component";
import {PanierService} from '../../../shared/services/impl/panier.service';

@Component({
  selector: 'ism-page-detail',
  imports: [ProduitItemComponent],
  templateUrl: './page-detail.component.html',
  styleUrl: './page-detail.component.css'
})
export class PageDetailComponent implements OnInit{

  constructor(private route: ActivatedRoute, private catalogueService: CatalogueService, private panierService: PanierService){
  }

  produitDetail? : ProduitDetail
  errorMessage : String = "";
  qteCom : number = 0;
  disabledButton : boolean = true;


  ngOnInit(): void {
    let id = this.route.snapshot.params['product_id']
    this.catalogueService.getProductDetailCatalogue(id).subscribe(
      data => {
        this.produitDetail = data
        // console.log(data.relatedProducts)
      },
      error => console.log(error)
    )
  }

  onValidateQte( qte: string){
    console.log(this.produitDetail?.produit.quantiteStock)
    if (qte === ""){
      this.errorMessage = "Ce champ est obligatoire"
    }else if(isNaN(Number(qte))){
      this.errorMessage = "Ce champ doit être un nombre"
    }else if(Number(qte) <= 0){
      this.errorMessage = "Ce champ doit être positif"
    } else if(Number(qte) > this.produitDetail!.produit.quantiteStock){
      this.errorMessage = "Cette quantité ne peut pas dépasser la quantité en stock"
    }else{
      this.errorMessage = "";
      this.qteCom = Number(qte);
      this.disabledButton = false;
    }
     /*
     * Récupérer la valeur saisie
    1 Coté template →
      #nomVariable
      nomVariable représente l'objet

    2 Coté Ts →Two Way DataBinding
    alert(this.qteCom)
     * */

    /*
    * Variable de template (pas trop de logique)
    * Template Form (pas trop de logique)
    * Reactive Form
    * */
  }


  onAddPanier() {
    this.panierService.addProduct({
      ...this.produitDetail?.produit!,
      quantiteCom : this.qteCom
    })
  }
}
