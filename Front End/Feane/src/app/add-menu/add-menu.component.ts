import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Menu } from '../shared/menu.model';
import { MenuService } from '../shared/menu.service';

declare var M: any;
@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css'],
  providers:[MenuService]
})

export class AddMenuComponent implements OnInit {

  
  constructor(public menuService: MenuService) { }

  ngOnInit(): void {
    this.resetForm();
    this.refreshMenuList();
  }

  resetForm(form?: NgForm) {
    if (form)
      form.reset();
    this.menuService.SelectedMenu = {
      _id: "",
      titre: "",
      code: "",
      
    }
  }

  onSubmit(form : NgForm){
    if(form.value._id == ""){

   
    this.menuService.postMenu(form.value).subscribe((res)=>{
    this.resetForm(form);
    this.refreshMenuList();
    M.toast({html : 'saved successfully', classes:'rounded'})
    });
  }
  else{
    this.menuService.putMenu(form.value).subscribe((res)=>{
      this.resetForm(form);
      this.refreshMenuList();
      M.toast({html : 'updated successfully', classes:'rounded'})
      });
  }
  }
 
  refreshMenuList(){
    this.menuService.getMenuList().subscribe((res)=>{
      this.menuService.menus = res as Menu[];
    });
  }


  onEdit(men : Menu){
    this.menuService.SelectedMenu = men;
  }

  onDelete(_id: string, form: NgForm) {
    if (confirm('Are you sure to delete this record ?') == true) {
      this.menuService.deleteMenu(_id).subscribe((res) => {
        this.refreshMenuList();
        this.resetForm(form);
        M.toast({ html: 'Deleted successfully', classes: 'rounded' });
      });
    }
  }
}
