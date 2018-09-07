@extends('master')

@section('title')
    About US
    
@endsection

@section('content')
	
	<div class="container">
	<form action="{{ route('saveNews') }}" class="form-group" method="post" >
    	<h3>Post a News</h3>
            <div class="form-group {{ $errors->has('newsCategory') ? 'has-error' : '' }}">
              <label for="type">News Category</label>
              <select class="form-control" type="text" name="newsCategory" id="newsCategory" >
            <option value="none" selected> -Select News Type- </option>
            <option value="National" >National</option>
            <option value="International" >International</option>
             <option value="Sports" >Sports</option>
            <option value="Entertainment" >Entertainment</option>
          </select>


           <label for="newsPriority">News Priority</label>
                    <select class="form-control" type="text" name="newsPriority" id="newsPriority" >
            <option value="none" selected> -Select News Priority- </option>
            <option value="Top" >Top</option>
            <option value="General" >General</option>
             
          </select>

          </div>

                <div class="form-group {{ $errors->has('newsTitle') ? 'has-error' : '' }}">
                    <label for="newsTitle">News Title</label>
                    <input class="form-control" type="text" name="newsTitle" id="newsTitle" value="{{ Request::old('newsTitle') }}">
                </div>
               
                <label for="newsBody">News Body</label>
                <textarea class="form-control" rows="15" name="newsBody" id="newsBody" placeholder="News Body"></textarea>
               
                
    	<button type="submit" class="btn btn-primary">Submit</button>
        <input type="hidden" value="{{ Session::token() }}" name="_token">
  	</form>
  	</div>

  
	 
@endsection