function timeToWalk(steps, footPrint, speed) {

    let totalRest = Math.floor((steps * footPrint) / 500);

    let totalTime = (steps * footPrint) / speed / 1000 * 60;


    let totalTimeInSeconds = Math.ceil((totalTime + totalRest) * 60);

    let result = new Date(null, null, null, null, null, totalTimeInSeconds);

    return result.toTimeString().split(' ')[0];
}
console.log(timeToWalk(4000, 0.60, 5));
