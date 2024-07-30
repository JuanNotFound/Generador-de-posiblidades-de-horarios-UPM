<h1> UPM Scheduling tool</h1>

<p>This simple project aims to use a backtracking algorithm to explore all possible schedule configurations based on the limited availability of class time slots.</p>
<p> The use is simple simply use a JSON with the following format: </p>


{
[
    {
        "name":"NAME OF CLASS",
        "code":"CODE IDENTIFY CLASS",
        "days": ["DAYS (IN SPANISH)"],
        "startTime":["TIME (FROM 9-21 in 2 hours interval"]
    },
    
     {
        "name":"NAME OF CLASS",
        "code":"CODE IDENTIFY CLASS",
        "days": ["DAYS (IN SPANISH)"],
        "startTime":["TIME (FROM 9-21 in 2 hours interval"]
    }
]
}

<h4>Considerations</h4>
- Schedule is really linked to my mother tongue 
- Schedule is also linked to UPM scheduling system
- The JSON has to contain only the classes you want to have
- The output is a console Log with all data 
