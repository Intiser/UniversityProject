@extends('master')

@section('title')
    Edit News
    
@endsection

@section('content')
	
	<div class="container">
	<form action="{{ route('editNews') }}" class="form-group" method="post" >
    	<h3>Edit News</h3>
            <div class="form-group {{ $errors->has('newsCategory') ? 'has-error' : '' }}">
              <label for="type">News Category</label>
              <select class="form-control" type="text" name="newsCategory" id="newsCategory" >
            <option value="none"  > -Select News Type- </option>
            @if($news->newsCategory == "National")
            <option value="National" selected >National</option>
            @else 
            	<option value="National" >National</option>
            @endif

             @if($news->newsCategory == "International")
            <option value="International" selected>International</option>
             @else 
            	<option value="International" >International</option>
            @endif

              @if($news->newsCategory == "Sports")
             <option value="Sports" selected >Sports</option>
             @else 
            	<option value="Sports" >Sports</option>
            @endif

            @if($news->newsCategory == "Entertainment")
            <option value="Entertainment" selected>Entertainment</option>
            @else 
            	<option value="Entertainment" >Entertainment</option>
            @endif

          </select>
          	

           <label for="newsPriority">News Priority</label>
           <select class="form-control" type="text" name="newsPriority" id="newsPriority" >
            <option value="none"> -Select News Priority- </option>
            @if($news->newsPriority == "Top")
            <option value="Top" selected>Top</option>
            @else 
            	<option value="Top" >Top</option>
            @endif

            @if($news->newsPriority == "General")
            <option value="General" selected >General</option>
             @else 
            	<option value="General" >General</option>
            @endif

       

          </select>


          </div>
          		<!-- <div class="form-group ">
          		 <label for="newsTitle">News Id (not editable)</label>
          		<select class="form-control" type="text" name="newsId" id="newsId" >
          			<option value="{{ $news->id }}" selected> {{ $news->id }}  </option>
          		</select>

          		</div> -->

          		<div class="form-group {{ $errors->has('newsTitle') ? 'has-error' : '' }}">
                    <label for="newsId">News Id</label>
                    <input class="form-control" type="text" name="newsId" id="newsId" value="{{ $news->id}}" readonly="readonly">
                </div>


                <div class="form-group {{ $errors->has('newsTitle') ? 'has-error' : '' }}">
                    <label for="newsTitle">News Title</label>
                    <input class="form-control" type="text" name="newsTitle" id="newsTitle" value="{{ $news->newsTitle}}" >
                </div>
               
                <label for="newsBody">News Body</label>
                <textarea class="form-control" rows="15" name="newsBody" id="newsBody" placeholder="News Body" > {{$news->newsBody }}</textarea>
               
                
    	<button type="submit" class="btn btn-primary">Submit</button>
        <input type="hidden" value="{{ Session::token() }}" name="_token">
  	</form>
  	</div>

@endsection