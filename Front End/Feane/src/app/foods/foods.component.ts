import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Food } from '../shared/food.model';
import { FoodService } from '../shared/food.service';
declare var F: any;
@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css'],
  providers:[FoodService]
})
export class FoodsComponent implements OnInit {

  constructor(public foodService:FoodService) { }

  ngOnInit(): void {
    this.resetForm();
    this.refreshFoodList();
  }

  resetForm(form?: NgForm) {
    if (form)
      form.reset();
    this.foodService.SelectedFood = {
      _id: "",
      code: "",
      libelle: "",
      prix: 0.00,
      image: "", 
    }
  }

  onSubmit(form : NgForm){
    if(form.value._id == ""){

   
    this.foodService.addFood(form.value).subscribe((res)=>{
    this.resetForm(form);
    this.refreshFoodList();
    F.toast({html : 'saved successfully', classes:'rounded'})
    });
  }
  else{
    this.foodService.updateFood(form.value).subscribe((res)=>{
      this.resetForm(form);
      this.refreshFoodList();
      F.toast({html : 'updated successfully', classes:'rounded'})
      });
  }
  }


  refreshFoodList(){
    this.foodService.getFoodList().subscribe((res)=>{
      this.foodService.foods = res as Food[];
    });
  }
  onEdit(foodd : Food){
    this.foodService.SelectedFood = foodd;
  }
  onDelete(_id: string, form: NgForm) {
    if (confirm('Are you sure to delete this record ?') == true) {
      this.foodService.deleteFood(_id).subscribe((res) => {
        this.refreshFoodList();
        this.resetForm(form);
        F.toast({ html: 'Deleted successfully', classes: 'rounded' });
      });
    }
  }
}
