import { Component } from '@angular/core';
import { PageDetailComponent } from './pages/catalogue/page-detail/page-detail.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { NavComponent } from './components/layout/nav/nav.component';
import { PageCatalogueComponent } from './pages/catalogue/page-catalogue/page-catalogue.component';
import { RouterOutlet } from '@angular/router';


@Component({
  standalone: true, // Ce composant peut charger d'autres composants
  selector: 'app-root',
  imports: [HeaderComponent, FooterComponent, NavComponent, RouterOutlet],
  templateUrl: './app.component.html',
  // template: `<h1>Angular 2 App</h1>`,
  styleUrl: './app.component.css'
  // styles:`h1 { color: #369; }`
})

// Le mot clé export permet de rendre la classe AppComponent accessible depuis d'autres fichiers


interface Link {
  name: string;
  path: string;
  class : string; // Optionnel
  subLinks?: Array<Link>; // Optionnel
  ariaCurrent?: string; // Optionnel
}
// Binding de données (data binding) : communication entre le composant et le template
//    * du composant(fichier ts) vers le template (fichier html) (envoie des données)
          // 1. Interpolation {{}}
          // 2. Property binding []
//    * du template (fichier html) vers le composant(fichier ts) (réception des données)
          // 3. Event binding ()
//    * les deux sens de communication
          // 4. Two-way binding [()]  

export class AppComponent {
  private title: string | null = null;
  private links: Link[] = [
    { name: 'Catalogue', path: '/catalogue', class:"nav-item", ariaCurrent: 'page'},
    { name: 'Detail', path: '/detail', class:"nav-item"}
  ];

  // constructor() {
  //   this.title = 'Angular 2 App';
  // }
}



