/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var a = init;
    return {
        increment:() =>{
            a++;
            return a;
        },
        reset:()=>{
            a=init;
            return a;
        },
        decrement:()=>{
            a--;
            return a;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */