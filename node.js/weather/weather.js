const request = require('request')
const geocode = require('./utils/geocode')
const forecast = require('./utils/forecast')

// const url = 'https://api.darksky.net/forecast/9d1465c6f3bb7a6c71944bdd8548d026/37.8267,-112'

// request({ url: url, json: true }, (error, response) => {
//     if (error) {
//         console.log('Unable to connect to weather service!')
//     } else if (response.body.error) {
//         console.log('Unable to find location')
//     } else {
//         console.log(response.body.daily.data[0].summary + ' It is currently ' + response.body.currently.temperature + ' degress out. There is a ' + response.body.currently.precipProbability + '% chance of rain.')   
//     }
// })

// const geocodeURL = 'https://api.mapbox.com/geocoding/v5/mapbox.places/Los%20Angeles.json?access_token=pk.eyJ1IjoidGlydGhiaGFyYXRpeWEiLCJhIjoiY2p2d2dvdXZkMDl4ZjRhdGhob2VtZm83ZyJ9.9wgNGMl1xvZObJ5EUrBHsQ'

// request({ url: geocodeURL, json: true }, (error, response) => {
//     if (error) {
//         console.log('Unable to connect to location services!')
//     } else if (response.body.features.length === 0) {
//         console.log('Unable to find location. Try another search.')
//     } else {
//         const latitude = response.body.features[0].center[0]
//         const longitude = response.body.features[0].center[1]
//         console.log(latitude, longitude)
//     }
// })



geocode('India',(error,data) => {
    console.log('Error', error)
    console.log('Data', data)

    forecast(data.latitude,data.longitude,(error,data)=>{
        console.log('Error: ',error)
        console.log('Data: ',data)
        
     })
})

// forecast(77,21,(error,data)=>{
//     console.log('Error: ',error)
//     console.log('Data: ',data)

// })