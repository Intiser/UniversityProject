@extends('master')

@section('title')
    OKAY
    

@endsection

@section('content')

    @if(Auth::user()->type == "Admin")
	<div class="row">
        <div class="col-md-6">
            <h3>Create User</h3>
            <form action="{{ route('createUser') }}" method="post">
                 <div class="form-group {{ $errors->has('type') ? 'has-error' : '' }}">
                    <label for="type">Type</label>
                    <select class="form-control" type="text" name="type" id="type" >
					  <option value="none" selected> -Select User Type- </option>
					  <option value="Admin" >Admin</option>
					  <option value="Moderator" >Moderator</option>
					</select>
                </div>

                <div class="form-group {{ $errors->has('email') ? 'has-error' : '' }}">
                    <label for="email">User E-mail</label>
                    <input class="form-control" type="text" name="email" id="email" value="{{ Request::old('email') }}">
                </div>
                <div class="form-group {{ $errors->has('password') ? 'has-error' : '' }}">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" name="password" id="password" value="{{ Request::old('password') }}">
                </div>
               
                <button type="submit" class="btn btn-primary active">Submit</button>
                <input type="hidden" name="_token" value="{{ Session::token() }}">
            </form>
        </div>
    
         <div class="container col-md-6">
        <table class="table table-striped table-hover">
        <thead>
          <h3>Users Lists</h3>

          <tr>
             <th>Email</th>
             <th>Type</th>
             <th>Option</th>
          </tr>
        </thead>
        <tbody>
         @foreach($users as $user)
        <tr>
             <th> {{ $user->email }}</th>
             <th>{{ $user->type }}</th>
             @if(Auth::user()->id == $user->id )
             <th>  </th>
             @else
                 <th> <a class="btn btn-danger" href="{{ route('user.delete', ['user_id' => $user->id] ) }}" >Delete</a> </th>
             @endif
        </tr>
         @endforeach
        

        </tbody>
        
        </table>
        </div>
    </div>

    <div class="row table-responsive">
         <div class="container ">
        <table class="table table-hover table-striped">
        <thead>
          <h3>Application Lists</h3>

          <tr>
             <th>Name</th>
             <th>Email</th>
             <th>Contact</th>
             <th>Address</th>
             <th>Nationality</th>
          </tr>
        </thead>
        <tbody>
         @foreach($applications as $application)
        <tr>
            <th>{{ $application->fullname }}</th>
            <th> {{ $application->email }}</th>
            <th>{{ $application->contact }}</th>
            <th>{{ $application->address }}</th>
            <th>{{ $application->nationality }}</th>             
         </tr>
         @endforeach
        

        </tbody>
        
        </table>
        </div>
    </div>
   @endif

@endsection