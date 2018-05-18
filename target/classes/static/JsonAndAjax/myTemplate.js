
                 {{#each pets}} 

                <div class="row">
     <div class="col-md-5" >
     
             <img src="{{photo}}" class="figure-img img-fluid rounded" width="350px" />

      </div>


     <div class="col-md-7">
           <h2>{{name}} <span class="lead">({{species}})</span></h2>
<p class="lead">Age: {{calculateAge birthYear}} </p>

{{#if favFoods}}
<h4 class="lead">Favorite Foods</h4>
<ul class="list-group">
{{#each favFoods}}
<li class="list-group-item list-group-item-info">
{{{this}}}
</li>
{{/each}}
</ul>
{{/if}}
     </div>

      
     </div>

                 {{/each}}
