db.createCollection("Employee", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["fname", "lname", "city"],
            properties: {
                fname: {
                    bsonType: "string",
                    description: "Must be a string and is required"
                },
                lname: {
                    bsonType: "string",
                    description: "Must be a string and is required"
                },
                salary: {
                    bsonType: "array",
                    description: "Array of numbers"
                },
                city: {
                    bsonType: "string",
                    description: "Must be a string"
                }
            }
        }
    }
});

data = [
    {
        'city': 'Banglore',
        'fname': 'Lance',
        'lname': 'Haynes',
        'salary': [37332,
            43386,
            40026,
            34923,
            43434,
            34818,
            34119,
            32823,
            40833,
            39582,
            30126,
            32175]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Brittany',
        'lname': 'Wolfe',
        'salary': [13673,
            12956,
            13821,
            13298,
            14798,
            12308,
            12101,
            14056,
            10737,
            12793,
            14732,
            10457]
    },
    {
        'city': 'Noida',
        'fname': 'Peter',
        'lname': 'Rios',
        'salary': [27082,
            25904,
            24730,
            26982,
            23638,
            21574,
            29790,
            27368,
            24986,
            26216,
            21388,
            29240]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Amena',
        'lname': 'Holcomb',
        'salary': [10478,
            12109,
            12746,
            10773,
            13096,
            13075,
            11522,
            10698,
            10353,
            10780,
            10198,
            13095]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Cairo',
        'lname': 'Compton',
        'salary': [37323,
            37548,
            33510,
            40683,
            38199,
            32334,
            40851,
            37590,
            42885,
            35745,
            37947,
            33768]
    },
    {
        'city': 'Banglore',
        'fname': 'Stacey',
        'lname': 'Gonzales',
        'salary': [30993,
            37515,
            37782,
            41844,
            38151,
            31266,
            37614,
            30033,
            43305,
            43014,
            39549,
            33891]
    },
    {
        'city': 'Banglore',
        'fname': 'Anastasia',
        'lname': 'Richmond',
        'salary': [37797,
            41136,
            31743,
            43539,
            30912,
            42252,
            42159,
            37800,
            43455,
            38370,
            30486,
            37434]
    },
    {
        'city': 'Hyderabad',
        'fname': 'Audrey',
        'lname': 'Garrett',
        'salary': [11295,
            13912,
            14353,
            14117,
            13215,
            10141,
            14504,
            13132,
            14428,
            12515,
            12318,
            14805]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Hashim',
        'lname': 'Brown',
        'salary': [25776,
            22002,
            27820,
            24606,
            29248,
            23686,
            20102,
            26668,
            25072,
            26694,
            23762,
            23234]
    },
    {
        'city': 'Hyderabad',
        'fname': 'Merritt',
        'lname': 'Cross',
        'salary': [11937,
            12748,
            11837,
            14522,
            10626,
            11428,
            11005,
            12755,
            12620,
            10314,
            10962,
            14608]
    },
    {
        'city': 'Banglore',
        'fname': 'Patrick',
        'lname': 'Berger',
        'salary': [34692,
            38529,
            36534,
            36414,
            37887,
            35511,
            44409,
            39771,
            37650,
            40809,
            38334,
            31368]
    },
    {
        'city': 'Noida',
        'fname': 'Evan',
        'lname': 'Harding',
        'salary': [41664,
            30270,
            40212,
            31833,
            30783,
            30747,
            32646,
            41121,
            39207,
            43497,
            35799,
            33345]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Brynne',
        'lname': 'Riley',
        'salary': [11882,
            12211,
            13335,
            14113,
            14117,
            10829,
            11786,
            14475,
            12421,
            14031,
            13352,
            11268]
    },
    {
        'city': 'Noida',
        'fname': 'Kai',
        'lname': 'Ruiz',
        'salary': [40377,
            40464,
            30744,
            36597,
            34701,
            32388,
            37398,
            35970,
            35538,
            35016,
            40884,
            34086]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Logan',
        'lname': 'Berger',
        'salary': [24536,
            21260,
            25282,
            23144,
            23892,
            25122,
            27706,
            22592,
            21390,
            24902,
            26912,
            29460]
    },
    {
        'city': 'Gurgaon',
        'fname': 'Paloma',
        'lname': 'Carlson',
        'salary': [39507,
            43329,
            39981,
            42303,
            44643,
            37593,
            41937,
            36927,
            43041,
            36885,
            39828,
            36903]
    }
]

db.Employee.insertMany(data);

db.Employee.find().pretty();

db.Employee.find({}, { fname: 1 }).pretty();

db.Employee.find({}, { _id: 0 }).pretty();

db.Employee.find().sort({ _id: 1 }).limit(5).pretty();

db.Employee.find().sort({ _id: 1 }).skip(5).limit(5).pretty();

db.Employee.find({ city: "Gurgaon" }).pretty();

db.Employee.find({ "salary.0": { $lt: 20000 } }).pretty();

db.Employee.find({ city: "Gurgaon", "salary.0": { $lt: 20000 } }).pretty();

db.Employee.aggregate([{ $group: { _id: null, count: { $sum: 1 }, "Total Jan Salary": { $sum: { $arrayElemAt: ["$salary", 0] } } } }]);

db.Employee.count({ city: "Gurgaon" });

